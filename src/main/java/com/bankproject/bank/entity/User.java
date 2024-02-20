package com.bankproject.bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;


    @Column(name = "username", nullable = false, length = 45)
    private String username;


    @Column(name = "password", nullable = false, length = 45)
    private String password;


    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "user_type", nullable = false)
    private String userType;

    @OneToOne(mappedBy = "user")
    private Account account;


}
