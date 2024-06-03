package br.com.ilima.picpay_challenge.adapter.output.database.persistence;

import br.com.ilima.picpay_challenge.adapter.exception.RegystryNotFoundException;
import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;
import br.com.ilima.picpay_challenge.adapter.output.database.repository.UserRepository;
import br.com.ilima.picpay_challenge.port.output.UserOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserPersistence implements UserOutputPort {

    private final UserRepository userRepository;

    public UserPersistence(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long countUserToTransferById(Long idPayer, Long idPayee) {
        return userRepository.countUserToTransferById(idPayer, idPayee);
    }

    @Override
    public UserModel findById(Long id) {

        Optional<UserModel> optionalUser = userRepository.findById(id);

        if(!optionalUser.isPresent()){
            throw new RegystryNotFoundException("User not found database");
        }

        return optionalUser.get();
    }
}
