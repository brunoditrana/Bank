package com.bankproject.bank.adapter;

import com.bankproject.bank.dto.services.*;
import com.bankproject.bank.entity.Services;

import java.util.List;

public interface ServicesAdapter {


    ServicesDTO CreateOneService(ServicesDTO servicesDTO);

    LoanDTO createOneLoan(LoanDTO loanDTO );

    DepositsDTO createOneDeposit(DepositsDTO dto);


    ExtractionsDTO createOneExtraction(ExtractionsDTO extractionsDTO);

    FixedTermDTO createOneFixedTerm(FixedTermDTO dto);

    List<LoanDTO> getAllLoan();
}
