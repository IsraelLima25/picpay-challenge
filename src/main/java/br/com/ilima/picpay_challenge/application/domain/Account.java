package br.com.ilima.picpay_challenge.application.domain;

import br.com.ilima.picpay_challenge.application.exception.BalanceInsufficientException;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance;

    public Account(BigDecimal balance) {
        this.balance = new BigDecimal("0.00");
    }

    public boolean isBalance(BigDecimal requestedValue){
        if(requestedValue.compareTo(this.balance) == -1){
            return false;
        }
        return true;
    }

    public void credit(BigDecimal value){
        this.balance.add(value);
    }

    public void debit(BigDecimal value){
        if(this.balance.compareTo(value) >= 0){
            this.balance.subtract(value);
        }
        throw new BalanceInsufficientException("Balance insufficient to transfer");
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
