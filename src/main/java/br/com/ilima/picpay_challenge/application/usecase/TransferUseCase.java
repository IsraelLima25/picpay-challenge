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

        LOGGER.info("Checking user id "+ userCreditValueTransfer.payer() +" and "+ userCreditValueTransfer.payee() +" exists");
        if(!existsUsers(userCreditValueTransfer.payer(), userCreditValueTransfer.payee())){
            LOGGER.error("User id "+userCreditValueTransfer.payer()+ " and "+ userCreditValueTransfer.payee()+" not exists");
            throw new UserNotExistsException("User not found");
        }
        LOGGER.info("User id "+userCreditValueTransfer.payer()+" and user id "+userCreditValueTransfer.payee()+ "exists");

        LOGGER.info("Find user payer by id "+userCreditValueTransfer.payer()+" in Database");
        UserModel userPayerEntity = userOutputPort.findById(userCreditValueTransfer.payer());
        LOGGER.info("Find user payee by id "+userCreditValueTransfer.payee()+" in Database");
        UserModel userPayeeEntity = userOutputPort.findById(userCreditValueTransfer.payee());

        LOGGER.info("User payer id "+userCreditValueTransfer.payer()+" and user payee id "+userCreditValueTransfer.payee()+" located");

        TransferUser userTransferDomain = UserTypeFactory.createUserPayer(userPayerEntity);
        User userPayeeDomain = UserTypeFactory.createUserPayee(userPayeeEntity);

        LOGGER.info("Start transfer to user payer "+userCreditValueTransfer.payer()+" from user payee id "+userCreditValueTransfer.payee());
        userTransferDomain.sendTransfer(userPayeeDomain, userCreditValueTransfer.value());
        LOGGER.info("Transfer success to user payer "+userCreditValueTransfer.payer()+" from user payee id "+userCreditValueTransfer.payee());

        User userPayerDomain = (User) userTransferDomain;

        LOGGER.info("Update balance payee id " +userCreditValueTransfer.payee());
        userPayeeEntity.getAccount().updateBalance(userPayeeDomain.getAccount().getBalance());
        LOGGER.info("Update balance payer id " +userCreditValueTransfer.payer());
        userPayerEntity.getAccount().updateBalance(userPayerDomain.getAccount().getBalance());

    }

    private boolean existsUsers(Long idPayer, Long idPayee){
       return userOutputPort.countUserToTransferById(idPayer, idPayee) == 2;
    }
}
