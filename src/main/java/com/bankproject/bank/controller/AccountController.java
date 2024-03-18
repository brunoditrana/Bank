package com.bankproject.bank.controller;

import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.dto.response.AccountResponse;
import com.bankproject.bank.mapper.AccountMapper;
import com.bankproject.bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;


    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountResponse> findByNumberAccount(@PathVariable Long accountNumber){

        AccountDTO accountDTO = accountService.findByAccountNumber(accountNumber);

        return ResponseEntity.ok().body(AccountMapper.INSTANCE.toResponse(accountDTO));

    }
}
