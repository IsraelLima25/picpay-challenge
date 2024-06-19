package br.com.ilima.picpay_challenge.application.usecase;

import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;
import br.com.ilima.picpay_challenge.port.output.UserOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class FindUserByIdUseCaseTest {

    @InjectMocks
    FindUserByIdUseCase findUserByIdUseCase;

    @Mock
    UserOutputPort userOutputPort;

    @Test
    void givenUserIdWhenFindUserByIdUseCaseCallThenReturnUser(){

        Mockito.when(userOutputPort.findById(1L)).thenReturn(new UserModel("user", "1245", "email@", null, null));

        UserModel result = findUserByIdUseCase.execute(1L);

        assertEquals("user", result.getName());
    }

}