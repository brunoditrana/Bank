package com.bankproject.bank.dto.request.services;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {




    private Double interestRate;

    private BigDecimal maximumAmount;

    private BigDecimal amount;

    private LocalDate date;



}
