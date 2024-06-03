package br.com.ilima.picpay_challenge.application.domain;

import br.com.ilima.picpay_challenge.application.exception.BalanceInsufficientException;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private BigDecimal balance;

    public Account() {
        this.balance = BigDecimal.ZERO;
    }

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isBalance(BigDecimal requestedValue){
        if(this.balance.compareTo(requestedValue) < 0){
            return false;
        }
        return true;
    }

    public void credit(BigDecimal value){
        if(!Objects.equals(value, new BigDecimal("0.00")) && !Objects.equals(value, BigDecimal.ZERO)){
            this.balance = this.balance.add(value);
        }else{
            throw new BalanceInsufficientException("Value zero insufficient to credit");
        }
    }

    public void debit(BigDecimal value){
        if(isBalance(value)){
            this.balance = this.balance.subtract(value);
        }else{
            throw new BalanceInsufficientException("Balance insufficient to debit");
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
