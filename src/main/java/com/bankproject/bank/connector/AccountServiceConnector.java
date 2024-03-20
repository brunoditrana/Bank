package com.bankproject.bank.connector;

import com.bankproject.bank.adapter.AccountServiceAdapter;
import com.bankproject.bank.dto.AccountServiceDTO;
import com.bankproject.bank.entity.AccountService;
import com.bankproject.bank.mapper.AccountServiceMapper;
import com.bankproject.bank.repository.AccountServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceConnector implements AccountServiceAdapter {

    @Autowired
    private AccountServiceRepository repo;

    @Override
    public void save(AccountServiceDTO dto) {

        AccountService accountService = repo.save(AccountServiceMapper.INSTANCE.toEntity(dto));

    }
}
