package br.com.ilima.picpay_challenge.application.domain;

import br.com.ilima.picpay_challenge.application.exception.CpfInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {

    private final String CPF_INVALID = "331.247.370-5";
    private final String CPF_VALID = "877.402.570-87";


    @Test
    void givenCpfInvalidWhenCpfVOConstructorThenThrowsCpfInvalidException(){

        assertThrows(CpfInvalidException.class, () -> {
            var cpf = new Cpf(CPF_INVALID);
        });
    }

    @Test
    void givenCpfValidWhenCpfVOConstructorThenConstructorCpf(){

        var cpf = new Cpf(CPF_VALID);

        assertEquals(CPF_VALID, cpf.getValue());
    }
}