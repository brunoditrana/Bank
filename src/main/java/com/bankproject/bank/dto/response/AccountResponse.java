package com.bankproject.bank.dto.response;

import com.bankproject.bank.entity.Profile;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {


    private Long idAccount;

    private LocalDate openingDate;

    private BigDecimal balance;

    private String state;

    private Profile profile;
}
