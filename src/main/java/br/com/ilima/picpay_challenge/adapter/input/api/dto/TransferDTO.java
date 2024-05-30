package br.com.ilima.picpay_challenge.adapter.input.api.dto;

import java.math.BigDecimal;

public record TransferDTO(
        BigDecimal value,
        Long payer,
        Long payee
) {}
