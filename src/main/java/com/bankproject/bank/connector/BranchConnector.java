package com.bankproject.bank.connector;

import com.bankproject.bank.adapter.BranchAdapter;
import com.bankproject.bank.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchConnector implements BranchAdapter {

    @Autowired
    private BranchRepository branchRepository;
}
