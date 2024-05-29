package br.com.ilima.picpay_challenge.adapter.output.database.persistence;

import br.com.ilima.picpay_challenge.application.domain.Common;
import br.com.ilima.picpay_challenge.application.domain.User;
import br.com.ilima.picpay_challenge.port.output.TransferOutputPort;
import org.springframework.stereotype.Component;

@Component
public class TransferPersistence implements TransferOutputPort {

    @Override
    public void execute(Common userDebitValueTransfer, User userCreditValueTransfer) { }

}
