package br.com.ilima.picpay_challenge.application.domain;

import br.com.ilima.picpay_challenge.application.exception.EmailInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    private final String EMAIL_INVALID = "captcha.captcha.com";
    private final String EMAIL_VALID = "captcha@captcha.com";


    @Test
    void givenEmailInvalidWhenEmailVOConstructorThenThrowsEmailInvalidException(){

        assertThrows(EmailInvalidException.class, () -> {
            var email = new Email(EMAIL_INVALID);
        });
    }

    @Test
    void givenEmailValidWhenEmailVOConstructorThenConstructorEmail(){

        var email = new Email(EMAIL_VALID);

        assertEquals(EMAIL_VALID, email.getValue());
    }

}