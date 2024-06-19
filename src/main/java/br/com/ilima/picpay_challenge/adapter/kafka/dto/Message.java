package br.com.ilima.picpay_challenge.adapter.kafka.dto;

import jakarta.validation.constraints.NotBlank;

public record Message(String key, @NotBlank String data) { }
