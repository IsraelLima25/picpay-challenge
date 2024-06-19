package br.com.ilima.picpay_challenge.adapter.exception;

public class FieldInvalid {

    private String field;
    private String message;

    public FieldInvalid(String message) {
        this.message = message;
    }

    public FieldInvalid(String field, String message) {
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
