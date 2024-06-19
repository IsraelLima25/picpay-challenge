package br.com.ilima.picpay_challenge.application.usecase;

import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;
import br.com.ilima.picpay_challenge.application.domain.TransferUser;
import br.com.ilima.picpay_challenge.application.domain.User;
import br.com.ilima.picpay_challenge.application.domain.factory.UserTypeFactory;
import br.com.ilima.picpay_challenge.application.dto.TransferDomainDTO;
import br.com.ilima.picpay_challenge.port.input.ExistsUserInputPort;
import br.com.ilima.picpay_challenge.port.input.FindUserByIdInputPort;
import br.com.ilima.picpay_challenge.port.input.FindUserPayerByIdInputPort;
import br.com.ilima.picpay_challenge.port.input.TransferInputPort;
import br.com.ilima.picpay_challenge.port.output.TransferOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferUseCase implements TransferInputPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferUseCase.class);

    private final TransferOutputPort transferOutputPort;
    private final ExistsUserInputPort existsUserInputPort;
    private final FindUserPayerByIdInputPort findUserPayerByIdInputPort;
    private final FindUserByIdInputPort findUserByIdInputPort;

    public TransferUseCase(ExistsUserInputPort existsUserInputPort, FindUserPayerByIdInputPort findUserPayerByIdInputPort,
            FindUserByIdInputPort findUserByIdInputPort, TransferOutputPort transferOutputPort) {
        this.existsUserInputPort = existsUserInputPort;
        this.findUserPayerByIdInputPort = findUserPayerByIdInputPort;
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.transferOutputPort = transferOutputPort;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void execute(TransferDomainDTO userCreditValueTransfer) {

        existsUserInputPort.execute(userCreditValueTransfer.payer(), userCreditValueTransfer.payee());
        UserModel userPayerEntity = findUserPayerByIdInputPort.execute(userCreditValueTransfer.payer());
        UserModel userPayeeEntity = findUserByIdInputPort.execute(userCreditValueTransfer.payee());

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

        LOGGER.info("Save transfer to user payer "+userCreditValueTransfer.payer()+" from user payee id "+userCreditValueTransfer.payee());
        transferOutputPort.save(userPayerEntity, userPayeeEntity, userCreditValueTransfer.value());
    }

}
