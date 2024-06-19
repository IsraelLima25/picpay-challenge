package br.com.ilima.picpay_challenge.application.usecase;

import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;
import br.com.ilima.picpay_challenge.port.input.FindUserByIdInputPort;
import br.com.ilima.picpay_challenge.port.output.UserOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FindUserByIdUseCase implements FindUserByIdInputPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindUserByIdUseCase.class);

    private final UserOutputPort userOutputPort;

    public FindUserByIdUseCase(UserOutputPort userOutputPort) {
        this.userOutputPort = userOutputPort;
    }

    @Override
    public UserModel execute(Long userId) {

        LOGGER.info("Find user payee by id "+userId+" in Database");
        UserModel userPayeeEntity = userOutputPort.findById(userId);
        LOGGER.info("User payer id "+userId+" and user payee id "+userId+" located");

        return userPayeeEntity;
    }
}
