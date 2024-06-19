package br.com.ilima.picpay_challenge.application.domain;

import br.com.ilima.picpay_challenge.application.exception.BalanceInsufficientException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CommonEntityTest {


    @Test
    void givenTransferToUserCommonEquals400WhenIsBalancePositiveThenReadyTransfer(){

        Common userCommonDebit = new Common("User Common Debit", new Cpf("331.247.370-59"),
                new Email("captcha@captcha.com"), "1234", new Account());
        userCommonDebit.getAccount().credit(new BigDecimal("600.00"));

        Common userCommonCredit = new Common("User Common Credit", new Cpf("120.752.030-67"),
                new Email("captcha1@captcha.com"), "4321", new Account());

        userCommonDebit.sendTransfer(userCommonCredit, new BigDecimal("400.00"));

        assertEquals(new BigDecimal("400.00"), userCommonCredit.getAccount().getBalance());
        assertEquals(new BigDecimal("200.00"), userCommonDebit.getAccount().getBalance());
    }

    @Test
    void givenTransferToUserShopkeeperEquals400WhenIsBalancePositiveThenReadyTransfer(){

        Common userCommonDebit = new Common("User Common Debit", new Cpf("331.247.370-59"),
                new Email("captcha@captcha.com"), "1234", new Account());
        userCommonDebit.getAccount().credit(new BigDecimal("600.00"));

        Shopkeeper userShopkeeperCredit = new Shopkeeper("User Shopkeeper Credit", new Cpf("120.752.030-67"),
                new Email("captcha1@captcha.com"), "4321", new Account());

        userCommonDebit.sendTransfer(userShopkeeperCredit, new BigDecimal("400.00"));

        assertEquals(new BigDecimal("400.00"), userShopkeeperCredit.getAccount().getBalance());
        assertEquals(new BigDecimal("200.00"), userCommonDebit.getAccount().getBalance());
    }

    @Test
    void givenTransferToUserShopkeeperEquals400WhenIsBalanceNegativeThenThrowBalanceInsufficientException(){

        Common userCommonDebit = new Common("User Common Debit", new Cpf("331.247.370-59"),
                new Email("captcha@captcha.com"), "1234", new Account());
        userCommonDebit.getAccount().credit(new BigDecimal("600.00"));

        Shopkeeper userShopkeeperCredit = new Shopkeeper("User Shopkeeper Credit", new Cpf("120.752.030-67"),
                new Email("captcha1@captcha.com"), "4321", new Account());

        assertThrows(BalanceInsufficientException.class,() -> {
            userCommonDebit.sendTransfer(userShopkeeperCredit, new BigDecimal("700.00"));
       });
    }

}