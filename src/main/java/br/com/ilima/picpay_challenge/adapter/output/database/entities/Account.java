package br.com.ilima.picpay_challenge.adapter.output.database.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_account")
public class Account {

    @Id
    @Column(name = "user_id")
    private Long id;
    private BigDecimal balance = BigDecimal.ZERO;

    public Account(){}

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public Account(User user) {
        this.user = user;
    }
}
