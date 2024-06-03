package br.com.ilima.picpay_challenge.application.exception;

public class BalanceInsufficientException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public BalanceInsufficientException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
