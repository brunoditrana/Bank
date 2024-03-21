package com.bankproject.bank.entity.services;


import com.bankproject.bank.entity.Account;
import com.bankproject.bank.entity.Services;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Extractions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_extractions")
    private Long idExtractions;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @OneToOne(mappedBy = "extractions")
    private Services services;

    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;
}

