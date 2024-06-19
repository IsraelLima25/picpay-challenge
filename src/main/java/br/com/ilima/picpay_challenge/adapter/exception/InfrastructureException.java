package br.com.ilima.picpay_challenge.adapter.exception;

public class InfrastructureException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String message;

    public InfrastructureException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
