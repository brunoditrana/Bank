package com.bankproject.bank.entity.services;

import com.bankproject.bank.entity.Account;
import com.bankproject.bank.entity.Services;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Deposits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deposits")
    private Long idDeposits;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "deposit_date", nullable = false)
    private LocalDate depositDate;

    @OneToOne(mappedBy = "deposits")
    private Services services;

    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;
}
