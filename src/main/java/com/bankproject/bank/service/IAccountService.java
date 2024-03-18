package com.bankproject.bank.service;

import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.dto.response.AccountResponse;

public interface IAccountService {


    AccountDTO findByAccountNumber(Long accountNumber);
}
