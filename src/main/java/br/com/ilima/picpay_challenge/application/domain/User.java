package br.com.ilima.picpay_challenge.application.domain;

public abstract class User {

    private String name;
    private Cpf cpf;
    private Email email;
    private String password;
    private Account account;

    public User(String name, Cpf cpf, Email email, String password, Account account) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Email getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Account getAccount() {
        return account;
    }

}
