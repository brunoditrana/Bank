package com.bankproject.bank.service;


import com.bankproject.bank.adapter.AccountAdapter;
import com.bankproject.bank.dto.AccountDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private AccountAdapter accountAdapter;

    @Override
    public AccountDTO findByAccountNumber(Long accountNumber) {

        return accountAdapter.findByAccountNumber(accountNumber);
    }
}
