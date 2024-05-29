package br.com.ilima.picpay_challenge.application.exception;

public class EmailInvalidException extends RuntimeException{

    private String messageDefault;

    public EmailInvalidException(String messageDefault) {
        super(messageDefault);
    }

    public String getMessageDefault() {
        return messageDefault;
    }
}
