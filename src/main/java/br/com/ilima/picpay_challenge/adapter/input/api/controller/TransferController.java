package br.com.ilima.picpay_challenge.adapter.input.api.controller;

import br.com.ilima.picpay_challenge.adapter.output.api.authorize.Authorize;
import br.com.ilima.picpay_challenge.adapter.input.api.dto.TransferInputDTO;
import br.com.ilima.picpay_challenge.port.input.TransferInputPort;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferController.class);

    private final TransferInputPort transferInputPort;
    private final Authorize authorize;

    public TransferController(TransferInputPort transferInputPort, Authorize authorize) {
        this.transferInputPort = transferInputPort;
        this.authorize = authorize;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void transfer(@Valid @RequestBody TransferInputDTO transferInputDTO) {
        LOGGER.info("Authentication transfer to id "+transferInputDTO.payer()+" from id " + transferInputDTO.payee());
        this.authorize.execute();
        LOGGER.info("Start request transfer to id "+transferInputDTO.payer()+" from id " + transferInputDTO.payee());
        transferInputPort.execute(transferInputDTO.toTransferDomainDTO());

        // TODO sendNotification Kafka Topic
    }
}
