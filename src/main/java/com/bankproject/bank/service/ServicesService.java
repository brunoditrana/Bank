package com.bankproject.bank.service;

import com.bankproject.bank.adapter.ServicesAdapter;
import com.bankproject.bank.dto.request.services.DepositsRequest;
import com.bankproject.bank.dto.request.services.ExtractionsRequest;
import com.bankproject.bank.dto.request.services.FixedTermRequest;
import com.bankproject.bank.dto.request.services.LoanRequest;
import com.bankproject.bank.dto.services.DepositsDTO;
import com.bankproject.bank.dto.services.ExtractionsDTO;
import com.bankproject.bank.dto.services.FixedTermDTO;
import com.bankproject.bank.dto.services.LoanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ServicesService implements IServicesService{

    @Autowired
    private ServicesAdapter servicesAdapter;

    @Override
    public LoanDTO createOneLoan(LoanRequest loanRequest) {

        //Validar entrada
        LoanDTO loanDTO = new LoanDTO();

        loanDTO.setInterestRate(loanRequest.getInterestRate());
        loanDTO.setMaximumAmount(loanRequest.getMaximumAmount());
        loanDTO.setAmount(new BigDecimal(0));
        loanDTO.setDate(loanRequest.getDate());

        return servicesAdapter.createOneLoan(loanDTO);

    }

    @Override
    public DepositsDTO createOneDeposit(DepositsRequest depositsRequest) {

        //Validar entrada
        DepositsDTO depositsDTO = new DepositsDTO();

        depositsDTO.setAmount(new BigDecimal(0));
        depositsDTO.setDepositDate(depositsRequest.getDepositDate());

        return servicesAdapter.createOneDeposit(depositsDTO);


    }

    @Override
    public ExtractionsDTO createOneExtraction(ExtractionsRequest extractionsRequest) {

        ExtractionsDTO extractionsDTO = new ExtractionsDTO();

        extractionsDTO.setAmount(extractionsRequest.getAmount());
        extractionsDTO.setCommission(extractionsRequest.getCommission());


        return servicesAdapter.createOneExtraction(extractionsDTO);
    }

    @Override
    public FixedTermDTO createOneFixedTerm(FixedTermRequest fixedTermDTO) {

        FixedTermDTO dto = new FixedTermDTO();

        dto.setInterestRate(fixedTermDTO.getInterestRate());
        dto.setMinimumAmount(fixedTermDTO.getMinimumAmount());
        dto.setAmount(fixedTermDTO.getAmount());
        dto.setDate(fixedTermDTO.getDate());
        dto.setFixedTermDurationEnum(fixedTermDTO.getFixedTermDurationEnum());

        return  servicesAdapter.createOneFixedTerm(dto);

    }


}
