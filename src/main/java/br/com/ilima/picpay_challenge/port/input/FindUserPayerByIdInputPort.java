package br.com.ilima.picpay_challenge.port.input;

import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;

public interface FindUserPayerByIdInputPort {

    UserModel execute(Long userPayerId);
}
