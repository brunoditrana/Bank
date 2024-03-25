package com.bankproject.bank.adapter;

import com.bankproject.bank.dto.BranchDTO;

public interface BranchAdapter {

    BranchDTO findByBranchCode(Integer branchCode);

    BranchDTO findByBranchName(String branchName);

    BranchDTO createOneBranch(BranchDTO branchDTO);

    void  deleteBranch(Integer branchCode);

}
