package br.com.ilima.picpay_challenge.adapter.output.database.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_account")
public class AccountModel {

    @Id
    @Column(name = "user_id")
    private Long id;
    private BigDecimal balance = BigDecimal.ZERO;

    public AccountModel(){}

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "user_id")
    private UserModel user;

    public AccountModel(UserModel user) {
        this.user = user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void updateBalance(BigDecimal newBalance){
        //Tratar Exception
        this.balance = newBalance;
    }
}
