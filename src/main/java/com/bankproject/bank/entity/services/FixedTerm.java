package com.bankproject.bank.entity.services;


import com.bankproject.bank.entity.Account;
import com.bankproject.bank.entity.Enum.FixedTermDurationEnum;
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
@Table(name = "fixed_term")
public class FixedTerm {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fixed_term")
    private Long idFixedTerm;

    @Column(name = "interest_rate", nullable = false)
    private Double interestRate;

    @Column(name = "minimum_amount", nullable = false)
    private BigDecimal minimumAmount;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "fixed_term_duration", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private FixedTermDurationEnum fixedTermDurationEnum;

    @OneToOne(mappedBy = "fixedTerm")
    private Services services;

    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;
}
