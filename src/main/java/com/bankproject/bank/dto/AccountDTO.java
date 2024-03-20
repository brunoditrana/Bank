package com.bankproject.bank.dto;

import com.bankproject.bank.entity.AccountService;
import com.bankproject.bank.entity.Branch;
import com.bankproject.bank.entity.Movements;
import com.bankproject.bank.entity.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Data

public class AccountDTO {



        private Long idAccount;

        private String typeAccount;

        private LocalDate openingDate;

        private BigDecimal balance;

        private String state;

        private ProfileDTO profile;

        private BranchDTO branch;

        private List<MovementsDTO> movements;

        private List<AccountService> accountServices;


}
