package br.com.ilima.picpay_challenge.application.usecase;

import br.com.ilima.picpay_challenge.adapter.output.database.model.AccountModel;
import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;
import br.com.ilima.picpay_challenge.application.domain.TypeUser;
import br.com.ilima.picpay_challenge.application.dto.TransferDomainDTO;
import br.com.ilima.picpay_challenge.application.exception.TransferInvalidException;
import br.com.ilima.picpay_challenge.application.exception.UserNotExistsException;
import br.com.ilima.picpay_challenge.port.input.ExistsUserInputPort;
import br.com.ilima.picpay_challenge.port.input.FindUserByIdInputPort;
import br.com.ilima.picpay_challenge.port.input.FindUserPayerByIdInputPort;
import br.com.ilima.picpay_challenge.port.output.TransferOutputPort;
import br.com.ilima.picpay_challenge.port.output.UserOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class TransferUseCaseTest {

    @InjectMocks
    TransferUseCase transferUseCase;

    @Mock
    ExistsUserInputPort existsUserInputPort;

    @Mock
    FindUserPayerByIdInputPort findUserPayerByIdInputPort;

    @Mock
    FindUserByIdInputPort findUserByIdInputPort;

    @Mock
    TransferOutputPort transferOutputPort;

    @Test
    void givenTransferUserCreditOrUserDebitValidWhenExecuteUseCaseThenProcessTransfer(){

        TransferDomainDTO dto = new TransferDomainDTO(new BigDecimal("100.00"), 1L, 2L);
        when(existsUserInputPort.execute(1L, 2L)).thenReturn(true);

        UserModel userPayer = new UserModel("Payer user", "036.659.147-67", "payer@gmail.com", "1236");
        userPayer.addAccount(new AccountModel(userPayer));
        userPayer.getAccount().updateBalance(new BigDecimal("300.00"));

        UserModel userPayee = new UserModel("Payee user", "369.654.693-98", "payee@gmail.com", "3256");
        userPayee.addAccount(new AccountModel(userPayee));
        userPayee.getAccount().updateBalance(new BigDecimal("300.00"));

        when(findUserPayerByIdInputPort.execute(1L)).thenReturn(userPayer);
        when(findUserByIdInputPort.execute(2L)).thenReturn(userPayee);

        transferUseCase.execute(dto);

        assertEquals(new BigDecimal("200.00"), userPayer.getAccount().getBalance());
        assertEquals(new BigDecimal("400.00"), userPayee.getAccount().getBalance());
    }

}