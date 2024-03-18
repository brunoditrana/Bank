package com.bankproject.bank.adapter;

import com.bankproject.bank.dto.BranchDTO;

public interface BranchAdapter {

    BranchDTO findByBranchCode(Integer branchCode);

}
