package br.com.ilima.picpay_challenge.adapter.input.api.dto;

import br.com.ilima.picpay_challenge.application.dto.TransferDomainDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransferInputDTO(
        @NotNull @Positive BigDecimal value,
        @NotNull @Positive Long payer,
        @NotNull @Positive Long payee
) {

    public TransferDomainDTO toTransferDomainDTO(){
        return new TransferDomainDTO(value, payer, payee);
    }
}
