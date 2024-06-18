package br.com.ilima.picpay_challenge.application.domain;

public enum TypeUser {

    COMMON("COMMON"), SHOPKEEPER("SHOPKEEPER");

    private String description;

    private TypeUser(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
