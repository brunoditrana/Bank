package com.bankproject.bank.service;

import com.bankproject.bank.dto.request.services.DepositsRequest;
import com.bankproject.bank.dto.request.services.ExtractionsRequest;
import com.bankproject.bank.dto.request.services.FixedTermRequest;
import com.bankproject.bank.dto.request.services.LoanRequest;
import com.bankproject.bank.dto.services.DepositsDTO;
import com.bankproject.bank.dto.services.ExtractionsDTO;
import com.bankproject.bank.dto.services.FixedTermDTO;
import com.bankproject.bank.dto.services.LoanDTO;

public interface IServicesService {


    LoanDTO createOneLoan(LoanRequest loanRequest);

    DepositsDTO createOneDeposit(DepositsRequest depositsRequest);


    ExtractionsDTO createOneExtraction(ExtractionsRequest extractionsRequest);

    FixedTermDTO createOneFixedTerm(FixedTermRequest fixedTermDTO);


}
