package com.bankproject.bank.dto.services;


import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.entity.Account;
import com.bankproject.bank.entity.Services;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanDTO {


    private Long idLoan;

    private Double interestRate;

    private Integer numberOfInstallments;

    private BigDecimal totalLoanAmount;

    private BigDecimal monthlyPayment;

    private LocalDate date;

    private ServicesDTO services;

    private AccountDTO account;

}

