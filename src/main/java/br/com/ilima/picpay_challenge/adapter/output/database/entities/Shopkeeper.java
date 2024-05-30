package br.com.ilima.picpay_challenge.adapter.output.database.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SHOPKEEPER")
public class Shopkeeper extends User {

    public Shopkeeper(){
        super();
    }

    public Shopkeeper(String name, String cpf, String email, String password) {
        super(name, cpf, email, password);
    }
}
