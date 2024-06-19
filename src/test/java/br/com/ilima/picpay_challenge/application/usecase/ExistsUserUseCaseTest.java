package br.com.ilima.picpay_challenge.application.usecase;

import br.com.ilima.picpay_challenge.application.domain.Account;
import br.com.ilima.picpay_challenge.application.exception.BalanceInsufficientException;
import br.com.ilima.picpay_challenge.application.exception.UserNotExistsException;
import br.com.ilima.picpay_challenge.port.input.ExistsUserInputPort;
import br.com.ilima.picpay_challenge.port.output.UserOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ExistsUserUseCaseTest {

    @InjectMocks
    ExistsUserUseCase existsUserUseCase;

    @Mock
    UserOutputPort userOutputPort;

    @Test
    void givenIdUserPayerNotExistsWhenExistsUseCaseCallThenThrowUserNotExistsException(){

        Mockito.when(userOutputPort.countUserToTransferById(1L, 2L)).thenReturn(1L);

        assertThrows(UserNotExistsException.class, () -> {
            existsUserUseCase.execute(3L, 2L);
        });
    }

    @Test
    void givenIdUserPayeeNotExistsWhenExistsUseCaseCallThenThrowUserNotExistsException(){

        Mockito.when(userOutputPort.countUserToTransferById(1L, 2L)).thenReturn(1L);

        assertThrows(UserNotExistsException.class, () -> {
            existsUserUseCase.execute(1L, 3L);
        });
    }

    @Test
    void givenIdUserPayeeExistsWhenExistsUseCaseCallThenReturnTrue(){

        Mockito.when(userOutputPort.countUserToTransferById(1L, 2L)).thenReturn(2L);
        Boolean result = existsUserUseCase.execute(1L, 2L);

        assertEquals(true, result);

    }
}