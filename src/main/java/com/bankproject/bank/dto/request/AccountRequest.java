package com.bankproject.bank.dto.request;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {


    private Long idAccount;

    private String typeAccount;

    private LocalDate openingDate;

    private BigDecimal balance;

    private String state;

    private String username;

}
