package br.com.ilima.picpay_challenge.adapter.output.database.repository;

import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("SELECT count(*) FROM UserModel u WHERE u.id IN (:idPayer, :idPayee)")
    Long countUserToTransferById(Long idPayer, Long idPayee);
}
