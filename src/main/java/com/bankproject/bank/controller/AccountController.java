package com.bankproject.bank.controller;

import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.dto.request.AccountRequest;
import com.bankproject.bank.dto.response.AccountResponse;
import com.bankproject.bank.mapper.AccountMapper;
import com.bankproject.bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;


    @GetMapping("/{idAccount}")
    public ResponseEntity<AccountResponse> findByNumberAccount(@PathVariable Long idAccount){

        AccountDTO accountDTO = accountService.findByIdAccount(idAccount);

        return ResponseEntity.ok().body(AccountMapper.INSTANCE.toResponse(accountDTO));

    }

    @PutMapping("/")
    public ResponseEntity<AccountResponse> editAccount(@RequestBody AccountRequest request){

        AccountResponse response = accountService.editAccount(request);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{idAccount}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long idAccount){

        String response = accountService.deleteAccount(idAccount);

       return ResponseEntity.ok().body(response);
    }


}
