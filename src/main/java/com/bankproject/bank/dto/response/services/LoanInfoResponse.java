package com.bankproject.bank.dto.response.services;


import com.bankproject.bank.entity.Account;
import com.bankproject.bank.entity.Services;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanInfoResponse {



    private Double interestRate;

    private BigDecimal maximumAmount;



}

