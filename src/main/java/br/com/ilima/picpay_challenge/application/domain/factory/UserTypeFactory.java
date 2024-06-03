package br.com.ilima.picpay_challenge.application.domain.factory;

import br.com.ilima.picpay_challenge.adapter.output.database.model.UserModel;
import br.com.ilima.picpay_challenge.application.domain.*;

public class UserTypeFactory {

    public static TransferUser createUserPayer(UserModel userPayerModel){
        return new Common(userPayerModel.getName(), new Cpf(userPayerModel.getCpf()), new Email(userPayerModel.getEmail()), userPayerModel.getPassword(), new Account(userPayerModel.getAccount().getBalance()));
    }

    public static User createUserPayee(UserModel userPayerModel){
        if(userPayerModel.getUserType() == "SHOPKEEPER"){
            return new Shopkeeper(userPayerModel.getName(), new Cpf(userPayerModel.getCpf()), new Email(userPayerModel.getEmail()), userPayerModel.getPassword(), new Account(userPayerModel.getAccount().getBalance()));
        }else{
            return new Common(userPayerModel.getName(), new Cpf(userPayerModel.getCpf()), new Email(userPayerModel.getEmail()), userPayerModel.getPassword(), new Account(userPayerModel.getAccount().getBalance()));
        }
    }
}
