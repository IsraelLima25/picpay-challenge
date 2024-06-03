package br.com.ilima.picpay_challenge.application.exception;

public class CpfInvalidException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public CpfInvalidException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
