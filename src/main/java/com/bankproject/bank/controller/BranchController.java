package com.bankproject.bank.controller;

import com.bankproject.bank.dto.BranchDTO;
import com.bankproject.bank.dto.response.BranchResponse;
import com.bankproject.bank.mapper.BranchMapper;
import com.bankproject.bank.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private IBranchService branchService;

    @GetMapping("/{branchCode}")
    public ResponseEntity<BranchResponse> findByBranchCode(@PathVariable Integer branchCode){

        BranchDTO branchDTO = branchService.findByBranchCode(branchCode);

        return ResponseEntity.ok().body(BranchMapper.INSTANCE.toResponse(branchDTO));
    }
}
