package com.bankproject.bank.dto.response;

import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.entity.Account;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchResponse {


    private Integer branchCode;

    private String branchName;

    private String city;

    private LocalDate openingDate;

    private List<AccountDTO> accounts;
}
