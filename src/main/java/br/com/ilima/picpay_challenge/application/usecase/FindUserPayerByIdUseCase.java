package br.com.ilima.picpay_challenge.application.usecase;

import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;
import br.com.ilima.picpay_challenge.application.domain.TypeUser;
import br.com.ilima.picpay_challenge.application.exception.TransferInvalidException;
import br.com.ilima.picpay_challenge.port.input.FindUserPayerByIdInputPort;
import br.com.ilima.picpay_challenge.port.output.UserOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FindUserPayerByIdUseCase implements FindUserPayerByIdInputPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindUserPayerByIdUseCase.class);

    private final UserOutputPort userOutputPort;

    public FindUserPayerByIdUseCase(UserOutputPort userOutputPort) {
        this.userOutputPort = userOutputPort;
    }

    @Override
    public UserModel execute(Long userPayerId) {
        LOGGER.info("Find user payer by id "+userPayerId+" in Database");
        UserModel userPayerEntity = userOutputPort.findById(userPayerId);

        if(userPayerEntity.getUserType().equals(TypeUser.SHOPKEEPER.getDescription())){
            throw new TransferInvalidException(TypeUser.class.descriptorString(),"Shopkeeper not transfer possible");
        }
        return userPayerEntity;
    }
}
