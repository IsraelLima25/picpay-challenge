package br.com.ilima.picpay_challenge.adapter.input.api.controller;

import br.com.ilima.picpay_challenge.adapter.input.api.dto.TransferDTO;
import br.com.ilima.picpay_challenge.application.usecase.TransferUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferController.class);

    private final TransferUseCase transferUseCase;

    public TransferController(TransferUseCase transferUseCase) {
        this.transferUseCase = transferUseCase;
    }

    public void transfer(TransferDTO transferDTO){ }
}
