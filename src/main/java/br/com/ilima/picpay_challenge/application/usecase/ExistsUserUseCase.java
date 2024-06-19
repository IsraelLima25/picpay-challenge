package br.com.ilima.picpay_challenge.application.usecase;

import br.com.ilima.picpay_challenge.application.exception.UserNotExistsException;
import br.com.ilima.picpay_challenge.port.input.ExistsUserInputPort;
import br.com.ilima.picpay_challenge.port.output.UserOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExistsUserUseCase implements ExistsUserInputPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExistsUserUseCase.class);

    private final UserOutputPort userOutputPort;

    public ExistsUserUseCase(UserOutputPort userOutputPort) {
        this.userOutputPort = userOutputPort;
    }

    @Override
    public Boolean execute(Long payerId, Long payeeId) {

        LOGGER.info("Checking user id " + payerId + " and " + payeeId + " exists");
        if (!existsUsers(payerId, payeeId)) {
            LOGGER.error("User id " + payerId + " and " + payeeId + " not exists");
            throw new UserNotExistsException("id_user","User not found");
        }
        LOGGER.info("User id " + payerId + " and user id " + payeeId + "exists");
        return true;
    }

    private boolean existsUsers(Long idPayer, Long idPayee){
        return userOutputPort.countUserToTransferById(idPayer, idPayee) == 2;
    }
}
