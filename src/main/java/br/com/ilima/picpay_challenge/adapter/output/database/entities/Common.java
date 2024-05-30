package br.com.ilima.picpay_challenge.adapter.output.database.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COMMON")
public class Common extends User {

    public Common() {
        super();
    }

    public Common(String name, String cpf, String email, String password) {
        super(name, cpf, email, password);
    }
}
