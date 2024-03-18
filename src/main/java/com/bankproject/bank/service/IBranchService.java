package com.bankproject.bank.service;

import com.bankproject.bank.dto.BranchDTO;
import com.bankproject.bank.dto.request.BranchRequest;

public interface IBranchService {


    BranchDTO findByBranchCode(Integer branchCode);

    BranchDTO createOneBranch(BranchRequest branchRequest);
}
