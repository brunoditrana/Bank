package com.bankproject.bank.service;

import com.bankproject.bank.adapter.BranchAdapter;
import com.bankproject.bank.dto.BranchDTO;
import com.bankproject.bank.dto.request.BranchRequest;
import com.bankproject.bank.dto.response.BranchResponse;
import com.bankproject.bank.mapper.BranchMapper;
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
    public BranchDTO findByBranchName(String branchName) {

        return branchAdapter.findByBranchName(branchName);

    }

    @Override
    public BranchDTO createOneBranch(BranchRequest branchRequest) {
        // validar el request de entrada

        BranchDTO branchDTO = new BranchDTO();

        branchDTO.setBranchCode(branchRequest.getBranchCode());
        branchDTO.setBranchName(branchRequest.getBranchName());
        branchDTO.setCity(branchRequest.getCity());
        branchDTO.setOpeningDate(branchRequest.getOpeningDate());

       return branchAdapter.createOneBranch(branchDTO);


    }

    @Override
    public BranchResponse updateBranch(BranchRequest request) {

        BranchDTO branchDTO = branchAdapter.findByBranchCode(request.getBranchCode());

        //VAlida que no sea null

        branchDTO.setBranchName(request.getBranchName());
        branchDTO.setCity(request.getCity());
        branchDTO.setOpeningDate(request.getOpeningDate());

        branchAdapter.createOneBranch(branchDTO);

        return BranchMapper.INSTANCE.toResponse(branchDTO);
    }

    @Override
    public String deleteBranch(Integer branchCode) {

        BranchDTO branchDTO = findByBranchCode(branchCode);

        //VAlida que no sea null

        branchAdapter.deleteBranch(branchDTO.getBranchCode());

        return "Branch successfully deleted";
    }
}
