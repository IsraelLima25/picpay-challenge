package br.com.ilima.picpay_challenge.adapter.output.database.repository;

import br.com.ilima.picpay_challenge.adapter.output.database.model.TransferModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<TransferModel, Long> { }
