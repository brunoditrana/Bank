package com.bankproject.bank.dto.response.services;


import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.dto.services.ServicesDTO;
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
public class ExtractionsResponse {


    private Long idExtractions;

    private BigDecimal amount;


    private ServicesDTO services;

    private AccountDTO account;
}

