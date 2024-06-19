package br.com.ilima.picpay_challenge.adapter.output.database.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SHOPKEEPER")
public class ShopkeeperModel extends UserModel {

    public ShopkeeperModel(){
        super();
    }

    public ShopkeeperModel(String name, String cpf, String email, String password) {
        super(name, cpf, email, password);
    }
}
