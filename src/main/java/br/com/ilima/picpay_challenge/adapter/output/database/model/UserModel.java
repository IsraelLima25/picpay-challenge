package br.com.ilima.picpay_challenge.adapter.output.database.model;

//Valorizar uso de index

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type",
        discriminatorType = DiscriminatorType.STRING)
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private String email;
    private String password;

    @Column(name = "user_type", insertable = false, updatable = false)
    private String userType;

    @OneToOne(mappedBy = "user")
    @PrimaryKeyJoinColumn
    private AccountModel accountModel;

    public UserModel(){ }

    public UserModel(String name, String cpf, String email, String password) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public AccountModel getAccount() {
        return accountModel;
    }

    public String getUserType() {
        return userType;
    }
}
