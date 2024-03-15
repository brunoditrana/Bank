package com.bankproject.bank.service;

import com.bankproject.bank.adapter.BranchAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService implements IBranchService{

    @Autowired
    private BranchAdapter branchAdapter;
}
