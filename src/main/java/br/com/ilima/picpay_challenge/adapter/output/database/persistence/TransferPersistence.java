package br.com.ilima.picpay_challenge.adapter.output.database.persistence;

import br.com.ilima.picpay_challenge.adapter.output.database.model.TransferModel;
import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;
import br.com.ilima.picpay_challenge.adapter.output.database.repository.TransferRepository;
import br.com.ilima.picpay_challenge.port.output.TransferOutputPort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransferPersistence implements TransferOutputPort {

    private final TransferRepository transferRepository;

    public TransferPersistence(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public void save(UserModel userPayer, UserModel userPayee, BigDecimal valueTransfer) {

        var transfer = new TransferModel(userPayer, userPayee, valueTransfer);
        transferRepository.save(transfer);
    }
}
