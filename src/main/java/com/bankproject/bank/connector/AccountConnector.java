package com.bankproject.bank.connector;

import com.bankproject.bank.adapter.AccountAdapter;
import com.bankproject.bank.dto.AccountDTO;

import com.bankproject.bank.entity.Account;
import com.bankproject.bank.mapper.AccountMapper;
import com.bankproject.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class AccountConnector implements AccountAdapter {


    @Autowired
    private AccountRepository accountRepository;


    @Override
    public AccountDTO findByIdAccount(Long idAccount ) {

        return AccountMapper.INSTANCE.toDTO( accountRepository.findById(idAccount).orElseThrow()
        //EXCEPTIONSSS
        );
    }

    @Override
    public AccountDTO createOneAccount(AccountDTO accountDTO) {

        Account a = accountRepository.save(AccountMapper.INSTANCE.toEntity(accountDTO));

        return AccountMapper.INSTANCE.toDTO(a);
    }

    @Override
    public void deleteAccount(Long idAccount) {

        accountRepository.deleteById(idAccount);

    }
}
