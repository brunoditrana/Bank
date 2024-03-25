package com.bankproject.bank.service;

import com.bankproject.bank.dto.BranchDTO;
import com.bankproject.bank.dto.request.BranchRequest;
import com.bankproject.bank.dto.response.BranchResponse;

public interface IBranchService {


    BranchDTO findByBranchCode(Integer branchCode);

    BranchDTO findByBranchName(String branchName);

    BranchDTO createOneBranch(BranchRequest branchRequest);

    BranchResponse updateBranch( BranchRequest request);


    String deleteBranch(Integer branchCode);
}
