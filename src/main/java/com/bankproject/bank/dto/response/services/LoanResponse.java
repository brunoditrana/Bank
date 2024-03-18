package com.bankproject.bank.dto.response.services;

import com.bankproject.bank.entity.Account;
import com.bankproject.bank.entity.Services;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponse {


    private Long idLoan;

    private Double interestRate;

    private BigDecimal maximumAmount;

    private BigDecimal amount;

    private LocalDate date;

    private Services services;

    private Account account;


}
