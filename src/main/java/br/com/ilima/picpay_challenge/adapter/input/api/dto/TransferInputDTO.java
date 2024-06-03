package br.com.ilima.picpay_challenge.adapter.input.api.dto;

import br.com.ilima.picpay_challenge.application.dto.TransferDomainDTO;

import java.math.BigDecimal;

public record TransferInputDTO(
        BigDecimal value,
        Long payer,
        Long payee
) {

    public TransferDomainDTO toTransferDomainDTO(){
        return new TransferDomainDTO(value, payer, payee);
    }
}
