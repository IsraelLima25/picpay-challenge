package br.com.ilima.picpay_challenge.application.domain;

import br.com.ilima.picpay_challenge.application.exception.BalanceInsufficientException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void givenAccountBalanceEqualsZeroWhenCallIsBalanceAccountThenReturnIsBalanceAccountFalse(){

        var account = new Account();

        assertFalse(account.isBalance(new BigDecimal("1.00")));
    }

    @Test
    void givenAccountBalanceEquals10WhenCallIsBalanceAccountThenReturnIsBalanceAccountTrue(){

        var account = new Account();
        account.credit(new BigDecimal("10.00"));

        assertTrue(account.isBalance(new BigDecimal("2.00")));
    }

    @Test
    void givenCreditAccountEquals100WhenCallCreditThenCreditValue(){

        var account = new Account();
        account.credit(new BigDecimal("100.00"));

        assertEquals(new BigDecimal("100.00"), account.getBalance());
    }

    @Test
    void givenCreditAccountEqualsZEROWhenCallCreditThenThrowBalanceInsufficientException(){

        assertThrows(BalanceInsufficientException.class, () -> {
            var account = new Account();
            account.credit(new BigDecimal("0.00"));
        });
    }

    @Test
    void givenDebitAccountEquals100WhenCallDebitAccountBalanceEquals200ThenDebitValue(){

        var account = new Account();
        account.credit(new BigDecimal("200.00"));
        account.debit(new BigDecimal("100.00"));

        assertEquals(new BigDecimal("100.00"), account.getBalance());
    }

    @Test
    void givenDebitAccountEquals100WhenCallDebitAccountBalanceEquals50ThenThrowBalanceInfuficientException(){

        var account = new Account();
        account.credit(new BigDecimal("50.00"));

        assertThrows(BalanceInsufficientException.class, () -> {
            account.debit(new BigDecimal("100.00"));
        });
    }
}