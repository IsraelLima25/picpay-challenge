package br.com.ilima.picpay_challenge.port.output;

import br.com.ilima.picpay_challenge.application.domain.Common;
import br.com.ilima.picpay_challenge.application.domain.User;

import java.math.BigDecimal;

public interface TransferOutputPort {

    void execute (Common userDebitValueTransfer, User userCreditValueTransfer);
}
