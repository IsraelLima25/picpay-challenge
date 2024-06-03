package br.com.ilima.picpay_challenge.application.dto;

import java.math.BigDecimal;

public record TransferDomainDTO(
        BigDecimal value,
        Long payer,
        Long payee
) { }
