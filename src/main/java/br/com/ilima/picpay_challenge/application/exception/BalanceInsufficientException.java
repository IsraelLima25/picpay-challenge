package br.com.ilima.picpay_challenge.application.exception;

public class BalanceInsufficientException extends RuntimeException {

    private String messageDefault;

    public BalanceInsufficientException(String messageDefault) {
        super(messageDefault);
    }

    public String getMessageDefault() {
        return messageDefault;
    }
}
