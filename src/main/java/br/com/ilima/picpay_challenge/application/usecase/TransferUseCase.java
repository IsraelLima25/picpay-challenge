package br.com.ilima.picpay_challenge.application.usecase;

import br.com.ilima.picpay_challenge.application.domain.TransferUser;
import br.com.ilima.picpay_challenge.application.domain.User;
import br.com.ilima.picpay_challenge.port.input.TransferInputPort;
import br.com.ilima.picpay_challenge.port.output.TransferOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferUseCase implements TransferInputPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferUseCase.class);

    private final TransferOutputPort transferOutputPort;

    public TransferUseCase(TransferOutputPort transferOutputPort) {
        this.transferOutputPort = transferOutputPort;
    }


    @Override
    public void execute(TransferUser userCreditValueTransfer, BigDecimal valueTransfer) {

    }
}
