package br.com.ilima.picpay_challenge.application.domain;

import br.com.ilima.picpay_challenge.application.exception.CpfInvalidException;

public class Cpf {

    private String value;

    public Cpf(String value) {
        if(value.matches("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$")){
            this.value = value;
        }else{
            throw new CpfInvalidException("Cpf Invalid");
        }
    }

    public String getValue() {
        return value;
    }
}
