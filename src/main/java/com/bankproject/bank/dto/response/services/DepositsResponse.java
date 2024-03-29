package com.bankproject.bank.dto.response.services;

import com.bankproject.bank.entity.Account;
import com.bankproject.bank.entity.Services;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepositsResponse {


    private Long idDeposits;

    private BigDecimal amount;

    private LocalDate depositDate;

    private Services services;

    private Account account;
}
