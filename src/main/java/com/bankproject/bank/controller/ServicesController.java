package com.bankproject.bank.controller;


import com.bankproject.bank.dto.request.services.DepositsRequest;
import com.bankproject.bank.dto.request.services.ExtractionsRequest;
import com.bankproject.bank.dto.request.services.FixedTermRequest;
import com.bankproject.bank.dto.request.services.LoanRequest;
import com.bankproject.bank.dto.response.services.*;
import com.bankproject.bank.dto.services.DepositsDTO;
import com.bankproject.bank.dto.services.ExtractionsDTO;
import com.bankproject.bank.dto.services.FixedTermDTO;
import com.bankproject.bank.dto.services.LoanDTO;
import com.bankproject.bank.mapper.services.DepositsMapper;
import com.bankproject.bank.mapper.services.ExtractionsMapper;
import com.bankproject.bank.mapper.services.FixedTermMapper;
import com.bankproject.bank.mapper.services.LoanMapper;
import com.bankproject.bank.service.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private IServicesService servicesService;



    @PostMapping("/deposits")
    public ResponseEntity<DepositsResponse> createOneDeposit(@RequestBody DepositsRequest depositsRequest){

        DepositsDTO dto = servicesService.createOneDeposit(DepositsMapper.INSTANCE.toDTO(depositsRequest));

        return  ResponseEntity.ok().body(DepositsMapper.INSTANCE.toResponse(dto));
    }

    @PostMapping("/extractions")
    public ResponseEntity<ExtractionsResponse> createOneExtraction(@RequestBody ExtractionsRequest extractionsRequest){

        ExtractionsDTO dto = servicesService.createOneExtraction(extractionsRequest);

        return  ResponseEntity.ok().body(ExtractionsMapper.INSTANCE.toResponse(dto));
    }

    @PostMapping("/fixedTerm")
    public ResponseEntity<FixedTermResponse> createOneFixedTerm(@RequestBody FixedTermRequest fixedTermRequest){

        FixedTermDTO dto = servicesService.createOneFixedTerm(fixedTermRequest);

        return  ResponseEntity.ok().body(FixedTermMapper.INSTANCE.toResponse(dto));
    }

    @PostMapping("/loan")
    public ResponseEntity<LoanResponse> createOneLoan(@RequestBody LoanRequest loanRequest){

        LoanDTO dto = servicesService.createOneLoan(loanRequest);

        return  ResponseEntity.ok().body(LoanMapper.INSTANCE.toResponse(dto));
    }

    @GetMapping("/") // no me convence mucho
    public ResponseEntity<List<LoanResponse>>  getAllLoan(){

        List<LoanDTO> list = servicesService.getAllLoan();

        return ResponseEntity.ok().body(LoanMapper.INSTANCE.toListResponse(list));
    }

    @GetMapping("/loanInfo")
    public ResponseEntity<LoanInfoResponse> loanInfo(){

        LoanInfoResponse loa = servicesService.loanInfo();

        return ResponseEntity.ok().body(loa);
    }

    @GetMapping("/fixedTermInfo")
    public ResponseEntity<FixedTermInfoResponse> fixedTermInfo(){

        FixedTermInfoResponse loa = servicesService.fixedTermInfo();

        return ResponseEntity.ok().body(loa);
    }


}

