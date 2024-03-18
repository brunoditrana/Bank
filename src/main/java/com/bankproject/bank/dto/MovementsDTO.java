package com.bankproject.bank.dto;

import com.bankproject.bank.entity.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovementsDTO {



    private Long idMovements;

    private String typeMovements;

    private BigDecimal amount;

    private LocalDate date;

    private String description;

    private Account account;

}