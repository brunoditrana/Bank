package com.bankproject.bank.connector;

import com.bankproject.bank.adapter.AccountAdapter;
import com.bankproject.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountConnector implements AccountAdapter {


    @Autowired
    private AccountRepository accountRepository;
}
