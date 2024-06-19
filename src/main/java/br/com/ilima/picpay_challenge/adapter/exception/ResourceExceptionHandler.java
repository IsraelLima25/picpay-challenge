package br.com.ilima.picpay_challenge.adapter.exception;

import br.com.ilima.picpay_challenge.application.exception.BalanceInsufficientException;
import br.com.ilima.picpay_challenge.application.exception.TransferInvalidException;
import br.com.ilima.picpay_challenge.application.exception.UserNotExistsException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ResourceExceptionHandler {

    private MessageSource messageSource;

    public ResourceExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public List<FieldInvalid> handlerArgumentNotValid(MethodArgumentNotValidException exception) {

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<FieldInvalid> fieldInvalids = extractErrors(fieldErrors);
        return fieldInvalids;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({TransferInvalidException.class})
    public FieldInvalid handlerTransferInvalidException(TransferInvalidException exception) {
        FieldInvalid fieldInvalid = new FieldInvalid(exception.getField(), exception.getMessage());
        return fieldInvalid;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UserNotExistsException.class})
    public FieldInvalid handlerUserNotExistsException(UserNotExistsException exception) {
        FieldInvalid fieldInvalid = new FieldInvalid(exception.getField(), exception.getMessage());
        return fieldInvalid;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BalanceInsufficientException.class})
    public FieldInvalid handlerBalanceInsufficientException(BalanceInsufficientException exception) {
        FieldInvalid fieldInvalid = new FieldInvalid(exception.getField(), exception.getMessage());
        return fieldInvalid;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({InfrastructureException.class})
    public FieldInvalid handlerInfrastructureException(InfrastructureException exception) {
        FieldInvalid fieldInvalid = new FieldInvalid(exception.getMessage());
        return fieldInvalid;
    }

    private List<FieldInvalid> extractErrors(List<FieldError> fieldErrors){
        List<FieldInvalid> camposInvalido = new ArrayList<>();
        fieldErrors.forEach(error -> {
            FieldInvalid fieldErro = new FieldInvalid(error.getField(),
                    messageSource.getMessage(error, LocaleContextHolder.getLocale()));
            camposInvalido.add(fieldErro);
        });
        return camposInvalido;
    }
}
