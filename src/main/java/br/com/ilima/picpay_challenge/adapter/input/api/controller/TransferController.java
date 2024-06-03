package br.com.ilima.picpay_challenge.adapter.input.api.controller;

import br.com.ilima.picpay_challenge.adapter.input.api.dto.TransferInputDTO;
import br.com.ilima.picpay_challenge.port.input.TransferInputPort;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferController.class);

    private final TransferInputPort transferInputPort;

    public TransferController(TransferInputPort transferInputPort) {
        this.transferInputPort = transferInputPort;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public void transfer(@Valid @RequestBody TransferInputDTO transferInputDTO) {
        transferInputPort.execute(transferInputDTO.toTransferDomainDTO());
    }
}
