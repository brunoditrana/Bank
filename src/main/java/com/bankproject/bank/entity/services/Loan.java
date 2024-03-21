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

public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loan")
    private Long idLoan;

    @Column(name = "interest_rate", nullable = false)
    private Double interestRate;

    @Column(name = "number_of_installments", nullable = false)
    private Integer numberOfInstallments;

    @Column(name = "total_loan_amount", nullable = false)
    private BigDecimal totalLoanAmount;

    @Column(name = "monthly_payment", nullable = false)
    private BigDecimal monthlyPayment;


    @Column(name = "date", nullable = false)
    private LocalDate date;

    @OneToOne(mappedBy = "loan")
    private Services services;

    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;

}

