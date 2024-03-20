package com.bankproject.bank.service;


import com.bankproject.bank.adapter.AccountAdapter;
import com.bankproject.bank.dto.AccountDTO;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.request.AccountRequest;
import com.bankproject.bank.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private AccountAdapter accountAdapter;

    @Autowired
    private IProfileService profileService;

    @Override
    public AccountDTO findByIdAccount(Long idAccount) {

        return accountAdapter.findByIdAccount(idAccount);
    }

    @Override
    public AccountDTO createOneAccount(AccountDTO accountDTO) {

        accountDTO.setTypeAccount("AGASDSA");
        accountDTO.setOpeningDate(LocalDate.now());
        accountDTO.setBalance(BigDecimal.ZERO);
        accountDTO.setState("Active");


       return accountAdapter.createOneAccount(accountDTO);

    }
}
