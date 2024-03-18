package com.bankproject.bank.service;


import com.bankproject.bank.adapter.AccountAdapter;
import com.bankproject.bank.dto.AccountDTO;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.request.AccountRequest;
import com.bankproject.bank.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private AccountAdapter accountAdapter;

    @Autowired
    private IProfileService profileService;

    @Override
    public AccountDTO findByAccountNumber(Long accountNumber) {

        return accountAdapter.findByAccountNumber(accountNumber);
    }

    @Override
    public AccountDTO createOneAccount(AccountRequest accountRequest) {

        // validar los datos del Account request

        ProfileDTO profileDTO = profileService.findByUsername(accountRequest.getUsername());

        if (profileDTO == null){
            //Enviar una Exception
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setAccountNumber(accountRequest.getAccountNumber());
        accountDTO.setTypeAccount(accountRequest.getTypeAccount());
        accountDTO.setOpeningDate(accountRequest.getOpeningDate());
        accountDTO.setBalance(accountRequest.getBalance());
        accountDTO.setState(accountDTO.getState());

        accountDTO.setProfile(ProfileMapper.INSTANCE.toEntity(profileDTO));

       return accountAdapter.createOneAccount(accountDTO);

    }
}
