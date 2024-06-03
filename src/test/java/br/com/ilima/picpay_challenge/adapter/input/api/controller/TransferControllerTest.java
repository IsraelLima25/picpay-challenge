package br.com.ilima.picpay_challenge.adapter.input.api.controller;

import br.com.ilima.picpay_challenge.adapter.input.api.dto.TransferInputDTO;
import br.com.ilima.picpay_challenge.port.input.TransferInputPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
@ContextConfiguration(classes = TransferController.class)
class TransferControllerTest {

    private static final String URI = "/transfers";
    private static ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TransferInputPort transferInputPort;

    @BeforeAll
    static void setupBeforeClass() {
        objectMapper = new ObjectMapper();
    }

    @BeforeEach
    void setupInitial(){ }

    @AfterEach
    void setupFinal(){ }

    @Test
    void givenJsonTransferInputDTOValidWhenTransferCallThenReturnStatusCode200() throws Exception {

        TransferInputDTO dto = new TransferInputDTO(new BigDecimal("100.00"), 1L, 1L);

        mockMvc.perform(MockMvcRequestBuilders.post(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk());


        verify(transferInputPort, times(1)).execute(dto.toTransferDomainDTO());
    }


}