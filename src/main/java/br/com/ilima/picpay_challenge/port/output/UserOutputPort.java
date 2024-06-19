package br.com.ilima.picpay_challenge.port.output;

import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;

public interface UserOutputPort {

    Long countUserToTransferById(Long idPayer, Long idPayee);
    UserModel findById(Long id);
}
