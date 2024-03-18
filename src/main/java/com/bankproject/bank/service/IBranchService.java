package com.bankproject.bank.service;

import com.bankproject.bank.dto.BranchDTO;

public interface IBranchService {


    BranchDTO findByBranchCode(Integer branchCode);
}
