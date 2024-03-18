package com.bankproject.bank.dto.request.services;


import com.bankproject.bank.entity.Account;
import com.bankproject.bank.entity.Services;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExtractionsRequest {



    private BigDecimal amount;

    private BigDecimal commission;

    private Services services;

    private Account account;
}

