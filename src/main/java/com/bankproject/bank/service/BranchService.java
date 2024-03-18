package com.bankproject.bank.service;

import com.bankproject.bank.adapter.BranchAdapter;
import com.bankproject.bank.dto.BranchDTO;
import com.bankproject.bank.dto.request.BranchRequest;
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

    @Override
    public BranchDTO createOneBranch(BranchRequest branchRequest) {
        // validar el request de entrada

        BranchDTO branchDTO = new BranchDTO();

        branchDTO.setBranchCode(branchRequest.getBranchCode());
        branchDTO.setBranchName(branchRequest.getBranchName());
        branchDTO.setCity(branchRequest.getCity());
        branchDTO.setOpeningDate(branchRequest.getOpeningDate());
        branchDTO.setNumberAccount(branchRequest.getNumberAccount());

       return branchAdapter.createOneBranch(branchDTO);


    }
}
