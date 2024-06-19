package br.com.ilima.picpay_challenge.port.input;

public interface ExistsUserInputPort {

    Boolean execute(Long payerId, Long payeeId);
}
