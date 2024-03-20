package com.bankproject.bank.dto;

import com.bankproject.bank.dto.services.ServicesDTO;
import com.bankproject.bank.entity.Account;
import com.bankproject.bank.entity.Services;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountServiceDTO {

    private Long idAccountService;


    private AccountDTO account;


    private ServicesDTO services;


}
