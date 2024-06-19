package br.com.ilima.picpay_challenge.application.exception;

public class TransferInvalidException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String field;
    private String message;

    public TransferInvalidException(String field, String message) {
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
