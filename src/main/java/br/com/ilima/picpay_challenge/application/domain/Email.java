package br.com.ilima.picpay_challenge.application.domain;

import br.com.ilima.picpay_challenge.application.exception.EmailInvalidException;

public class Email {

    private String value;

    public Email(String value) {
        if(value.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            this.value = value;
        }else{
            throw new EmailInvalidException("Email Invalid");
        }
    }

    public String getValue() {
        return value;
    }
}
