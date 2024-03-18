package com.bankproject.bank.adapter;

import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.dto.ProfileDTO;

public interface AccountAdapter {


    AccountDTO findByAccountNumber(Long accountNumber);
}
