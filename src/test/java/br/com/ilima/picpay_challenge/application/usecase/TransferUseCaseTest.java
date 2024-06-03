package br.com.ilima.picpay_challenge.application.usecase;

import br.com.ilima.picpay_challenge.application.dto.TransferDomainDTO;
import br.com.ilima.picpay_challenge.application.exception.UserNotExistsException;
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
    UserOutputPort userOutputPort;

    @Test
    void givenTransferUserCreditOrUserDebitNotExistsWhenExecuteUseCaseThenThrowUserNotExistsException(){

        TransferDomainDTO dto = new TransferDomainDTO(new BigDecimal("100.00"), 1L, 1L);

        when(userOutputPort.countUserToTransferById(1L, 1L)).thenReturn(1L);

        assertThrows(UserNotExistsException.class, () -> {
            transferUseCase.execute(dto);
        });
    }

    @Test
    void givenTransferUserCreditOrUserDebitValidWhenExecuteUseCaseThenProcessTransfer(){

        TransferDomainDTO dto = new TransferDomainDTO(new BigDecimal("100.00"), 1L, 1L);
        when(userOutputPort.countUserToTransferById(1L, 1L)).thenReturn(2L);
        when(userOutputPort.findById(1L)).thenReturn(any());

        transferUseCase.execute(dto);

    }
}