package br.com.ilima.picpay_challenge.port.input;

import br.com.ilima.picpay_challenge.application.domain.Common;
import br.com.ilima.picpay_challenge.application.domain.TransferUser;
import br.com.ilima.picpay_challenge.application.domain.User;

import java.math.BigDecimal;

public interface TransferInputPort {

    void execute (TransferUser userCreditValueTransfer, BigDecimal valueTransfer);
}
