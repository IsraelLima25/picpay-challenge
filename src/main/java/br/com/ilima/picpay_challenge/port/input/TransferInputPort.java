package br.com.ilima.picpay_challenge.port.input;

import br.com.ilima.picpay_challenge.application.dto.TransferDomainDTO;

public interface TransferInputPort {

    void execute (TransferDomainDTO userCreditValueTransfer);
}
