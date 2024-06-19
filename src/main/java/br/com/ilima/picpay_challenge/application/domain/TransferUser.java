package br.com.ilima.picpay_challenge.application.domain;

import java.math.BigDecimal;

public interface TransferUser {

    void sendTransfer(User userDeposited, BigDecimal valueDeposited);
}
