package br.com.ilima.picpay_challenge.adapter.kafka.service;

import br.com.ilima.picpay_challenge.adapter.input.api.controller.TransferController;
import br.com.ilima.picpay_challenge.adapter.kafka.dto.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public StringService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Message message){
        kafkaTemplate.send("str-topic",message.key(), message.data()).whenComplete(
                (result, e) ->{
                    if(e != null){
                        LOGGER.info("Error send message: {}", e.getMessage());
                    }else{
                        LOGGER.info("Success send message in partition: {} and offset: {}",
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());
                    }
                }
        );
    }
}
