package br.com.ilima.picpay_challenge.adapter.output.database.entities;

import jakarta.persistence.*;

//Valorizar uso de index

@Entity
@Table(name = "tbl_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private String email;
    private String password;

    @OneToOne(mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Account account;

    public User(){ }

    public User(String name, String cpf, String email, String password) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }
}
