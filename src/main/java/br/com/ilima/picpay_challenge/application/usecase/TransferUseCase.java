package br.com.ilima.picpay_challenge.application.usecase;

import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;
import br.com.ilima.picpay_challenge.application.domain.TransferUser;
import br.com.ilima.picpay_challenge.application.domain.User;
import br.com.ilima.picpay_challenge.application.domain.factory.UserTypeFactory;
import br.com.ilima.picpay_challenge.application.dto.TransferDomainDTO;
import br.com.ilima.picpay_challenge.application.exception.UserNotExistsException;
import br.com.ilima.picpay_challenge.port.input.TransferInputPort;
import br.com.ilima.picpay_challenge.port.output.TransferOutputPort;
import br.com.ilima.picpay_challenge.port.output.UserOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransferUseCase implements TransferInputPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferUseCase.class);

    private final UserOutputPort userOutputPort;

    public TransferUseCase(UserOutputPort userOutputPort) {
        this.userOutputPort = userOutputPort;
    }

    @Override
    public void execute(TransferDomainDTO userCreditValueTransfer) {

        if(!existsUsers(userCreditValueTransfer.payer(), userCreditValueTransfer.payee())){
            throw new UserNotExistsException("User not found");
        }

        UserModel userPayerEntity = userOutputPort.findById(userCreditValueTransfer.payer());
        UserModel userPayeeEntity = userOutputPort.findById(userCreditValueTransfer.payee());

        TransferUser userTransferDomain = UserTypeFactory.createUserPayer(userPayerEntity);
        User userPayeeDomain = UserTypeFactory.createUserPayee(userPayeeEntity);

        userTransferDomain.sendTransfer(userPayeeDomain, userCreditValueTransfer.value());

        User userPayerDomain = (User) userTransferDomain;

        userPayeeEntity.getAccount().updateBalance(userPayeeDomain.getAccount().getBalance());
        userPayerEntity.getAccount().updateBalance(userPayerDomain.getAccount().getBalance());

    }

    private boolean existsUsers(Long idPayer, Long idPayee){
       return userOutputPort.countUserToTransferById(idPayer, idPayee) == 2;
    }
}
