package com.bankproject.bank.adapter;

import com.bankproject.bank.dto.services.DepositsDTO;
import com.bankproject.bank.dto.services.ExtractionsDTO;
import com.bankproject.bank.dto.services.FixedTermDTO;
import com.bankproject.bank.dto.services.LoanDTO;
import com.bankproject.bank.entity.Services;

public interface ServicesAdapter {


    LoanDTO createOneLoan(LoanDTO loanDTO );

    DepositsDTO createOneDeposit(DepositsDTO dto);


    ExtractionsDTO createOneExtraction(ExtractionsDTO extractionsDTO);

    FixedTermDTO createOneFixedTerm(FixedTermDTO dto);
}
