package com.bankproject.bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Long idAccount;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "type_account", nullable = false)
    private String typeAccount;

    @Column(name = "opening_date", nullable = false)
    private LocalDate openingDate;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "state", nullable = false)
    private String state;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_branch")
    private Branch branch;

    @OneToMany(mappedBy = "account")
    private List<Movements> movements;

    @OneToMany(mappedBy = "account")
    private List<AccountService> accountServices;

}
