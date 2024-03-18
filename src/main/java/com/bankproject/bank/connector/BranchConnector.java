package com.bankproject.bank.connector;

import com.bankproject.bank.adapter.BranchAdapter;
import com.bankproject.bank.dto.BranchDTO;
import com.bankproject.bank.entity.Branch;
import com.bankproject.bank.mapper.BranchMapper;
import com.bankproject.bank.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchConnector implements BranchAdapter {

    @Autowired
    private BranchRepository branchRepository;


    @Override
    public BranchDTO findByBranchCode(Integer branchCode) {

        Branch branch = branchRepository.findByBranchCode(branchCode);

        return BranchMapper.INSTANCE.toDTO(branch);
    }

    @Override
    public BranchDTO createOneBranch(BranchDTO branchDTO) {

        Branch branch = branchRepository.save(BranchMapper.INSTANCE.toEntity(branchDTO));

        return BranchMapper.INSTANCE.toDTO(branch);
    }
}
