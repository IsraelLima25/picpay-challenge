package br.com.ilima.picpay_challenge.application.domain;

import br.com.ilima.picpay_challenge.application.exception.BalanceInsufficientException;

import java.math.BigDecimal;

public class Common extends User implements TransferUser {


    public Common(String name, Cpf cpf, Email email, String password, Account account) {
        super(name, cpf, email, password, account);
    }

    @Override
    public void sendTransfer(User userDeposited, BigDecimal valueDeposited) {
        if(this.getAccount().isBalance(valueDeposited)){
            this.getAccount().debit(valueDeposited);
            userDeposited.getAccount().credit(valueDeposited);
        }else{
            throw new BalanceInsufficientException("value_deposited","Balance insufficient to transfer");
        }
    }
}
