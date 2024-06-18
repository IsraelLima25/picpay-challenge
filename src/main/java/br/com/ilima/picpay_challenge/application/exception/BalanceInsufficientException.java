package br.com.ilima.picpay_challenge.application.exception;

public class BalanceInsufficientException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String field;
    private String message;

    public BalanceInsufficientException(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
