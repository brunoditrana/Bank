package com.bankproject.bank.dto.response;


import com.bankproject.bank.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementsResponse {



    private String typeMovements;

    private BigDecimal amount;

    private LocalDate date;

    private String description;

    private Account account;
}
