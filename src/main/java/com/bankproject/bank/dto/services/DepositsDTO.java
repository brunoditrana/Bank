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
public class DepositsDTO {


    private Long idDeposits;

    private BigDecimal amount;

    private LocalDate depositDate;

    private ServicesDTO services;

    private AccountDTO account;
}
