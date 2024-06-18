package br.com.ilima.picpay_challenge.port.output;

import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;
import br.com.ilima.picpay_challenge.application.domain.Common;
import br.com.ilima.picpay_challenge.application.domain.User;

import java.math.BigDecimal;

public interface TransferOutputPort {

    void save (UserModel userPayer, UserModel userPayee, BigDecimal valueTransfer);
}
