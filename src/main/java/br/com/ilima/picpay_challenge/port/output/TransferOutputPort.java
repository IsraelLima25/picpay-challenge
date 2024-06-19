package br.com.ilima.picpay_challenge.port.output;

import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;

import java.math.BigDecimal;

public interface TransferOutputPort {

    void save (UserModel userPayer, UserModel userPayee, BigDecimal valueTransfer);
}
