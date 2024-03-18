package com.bankproject.bank.service;

import com.bankproject.bank.adapter.BranchAdapter;
import com.bankproject.bank.dto.BranchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService implements IBranchService{

    @Autowired
    private BranchAdapter branchAdapter;


    @Override
    public BranchDTO findByBranchCode(Integer branchCode) {

        return branchAdapter.findByBranchCode(branchCode);
    }
}
