package com.bankproject.bank.service;


import com.bankproject.bank.adapter.AccountAdapter;
import com.bankproject.bank.dto.AccountDTO;

import com.bankproject.bank.dto.BranchDTO;
import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.request.AccountRequest;
import com.bankproject.bank.dto.response.AccountResponse;
import com.bankproject.bank.mapper.AccountMapper;
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

    @Autowired
    private IBranchService branchService;

    @Override
    public AccountDTO findByIdAccount(Long idAccount) {

        return accountAdapter.findByIdAccount(idAccount);
    }

    @Override
    public AccountDTO createOneAccount(AccountDTO accountDTO) {


        accountDTO.setOpeningDate(LocalDate.now());
        accountDTO.setBalance(BigDecimal.ZERO);
        accountDTO.setState("Active");


       return accountAdapter.createOneAccount(accountDTO);

    }

    @Override
    public AccountResponse editAccount(AccountRequest accountRequest) {

        AccountDTO accountDTO = findByIdAccount(accountRequest.getIdAccount());

        //Validar si el Account viene

        BranchDTO branchDTO = branchService.findByBranchName(accountRequest.getBranchName());

        //Validar si el branch viene

        accountDTO.setBranch(branchDTO);
        accountDTO.setState(accountRequest.getState());
        accountDTO.setOpeningDate(accountRequest.getOpeningDate());

        accountAdapter.createOneAccount(accountDTO);

        return AccountMapper.INSTANCE.toResponse(accountDTO);
    }

    @Override
    public String deleteAccount(Long idAccount) {

        AccountDTO accountDTO = findByIdAccount(idAccount);

        //Validar si el Account viene

        accountAdapter.deleteAccount(idAccount);

        return "Successfully deleted account";
    }
}
