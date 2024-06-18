package br.com.ilima.picpay_challenge.application.usecase;

import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;
import br.com.ilima.picpay_challenge.application.domain.TypeUser;
import br.com.ilima.picpay_challenge.application.exception.TransferInvalidException;
import br.com.ilima.picpay_challenge.port.output.UserOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class FindUserPayerByIdUseCaseTest {

    @InjectMocks
    FindUserPayerByIdUseCase findUserPayerByIdUseCase;

    @Mock
    UserOutputPort userOutputPort;

    @Test
    void givenUserPayerIdWhenFindUserPayerByIdUseCaseCallThenReturnUser(){

        Mockito.when(userOutputPort.findById(1L)).thenReturn(new UserModel("user", "1245", "email@", null, TypeUser.COMMON.getDescription()));

        UserModel result = findUserPayerByIdUseCase.execute(1L);

        assertEquals("user", result.getName());
    }

    @Test
    void givenUserPayeeIdWhenFindUserPayerByIdUseCaseCallThenThrowTransferInvalidException(){

        Mockito.when(userOutputPort.findById(1L)).thenReturn(new UserModel("user", "1245", "email@", null, TypeUser.SHOPKEEPER.getDescription()));

        assertThrows(TransferInvalidException.class, ()-> {
            findUserPayerByIdUseCase.execute(1L);
        });
    }

}