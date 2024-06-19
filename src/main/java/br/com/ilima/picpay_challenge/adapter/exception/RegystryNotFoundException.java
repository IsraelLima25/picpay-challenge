package br.com.ilima.picpay_challenge.adapter.exception;

public class RegystryNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String field;
    private String message;

    public RegystryNotFoundException(String field, String message) {
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
