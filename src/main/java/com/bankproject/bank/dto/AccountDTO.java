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


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class AccountDTO {



        private Long idAccount;

        private String accountNumber;

        private String typeAccount;

        private LocalDate openingDate;

        private BigDecimal balance;

        private String state;

        private Profile profile;

        private Branch branch;

        private List<Movements> movements;


        private List<AccountService> accountServices;


}
