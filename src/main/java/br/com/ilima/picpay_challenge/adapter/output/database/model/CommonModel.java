package br.com.ilima.picpay_challenge.adapter.output.database.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COMMON")
public class CommonModel extends UserModel {

    public CommonModel() {
        super();
    }

    public CommonModel(String name, String cpf, String email, String password) {
        super(name, cpf, email, password);
    }
}
