package br.com.ilima.picpay_challenge.application.domain;

public class Shopkeeper extends User{

    public Shopkeeper(String name, Cpf cpf, Email email, String password, Account account) {
        super(name, cpf, email, password, account);
    }
}
