package com.bankproject.bank.dto.request;

import com.bankproject.bank.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchRequest {


    private Integer branchCode;

    private String branchName;

    private String city;

    private LocalDate openingDate;

    private Integer numberAccount;



}
