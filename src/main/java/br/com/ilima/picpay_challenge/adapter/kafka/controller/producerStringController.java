package br.com.ilima.picpay_challenge.adapter.kafka.controller;

import br.com.ilima.picpay_challenge.adapter.kafka.dto.Message;
import br.com.ilima.picpay_challenge.adapter.kafka.service.StringService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer/string")
public class producerStringController {

    private final StringService stringService;

    public producerStringController(StringService stringService) {
        this.stringService = stringService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void producerString(@Valid @RequestBody Message message){
        stringService.sendMessage(message);
    }
}
