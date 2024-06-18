package br.com.ilima.picpay_challenge.adapter.output.database.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_transfer")
public class TransferModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_payer")
    private UserModel userPayer;

    @ManyToOne
    @JoinColumn(name = "id_payee")
    private UserModel userPayee;

    @JoinColumn(name = "value_transfer")
    private BigDecimal valueTransfer;

    public TransferModel(UserModel userPayer, UserModel userPayee, BigDecimal valueTransfer) {
        this.userPayer = userPayer;
        this.userPayee = userPayee;
        this.valueTransfer = valueTransfer;
    }

    public Long getId() {
        return id;
    }

    public UserModel getUserPayer() {
        return userPayer;
    }

    public UserModel getUserPayee() {
        return userPayee;
    }

    public BigDecimal getValueTransfer() {
        return valueTransfer;
    }
}
