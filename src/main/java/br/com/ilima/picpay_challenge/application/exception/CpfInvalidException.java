package br.com.ilima.picpay_challenge.application.exception;

public class CpfInvalidException extends RuntimeException {

    private String messageDefault;

    public CpfInvalidException(String messageDefault) {
        super(messageDefault);
    }

    public String getMessageDefault() {
        return messageDefault;
    }
}
