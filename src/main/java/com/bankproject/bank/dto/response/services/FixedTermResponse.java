package com.bankproject.bank.dto.response.services;


import com.bankproject.bank.entity.Account;
import com.bankproject.bank.entity.Enum.FixedTermDurationEnum;
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
public class FixedTermResponse {



    private Long idFixedTerm;

    private Double interestRate;

    private BigDecimal minimumAmount;

    private BigDecimal amount;

    private LocalDate date;

    private FixedTermDurationEnum fixedTermDurationEnum;

    private Services services;

    private Account account;
}
