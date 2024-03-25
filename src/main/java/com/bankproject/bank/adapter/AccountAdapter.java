package com.bankproject.bank.adapter;

import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.request.AccountRequest;

public interface AccountAdapter {


    AccountDTO findByIdAccount(Long idAccount);

    AccountDTO createOneAccount(AccountDTO accountDTO);

    void deleteAccount(Long idAccount);
}
