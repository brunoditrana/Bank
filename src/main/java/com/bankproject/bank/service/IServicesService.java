package com.bankproject.bank.service;

import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.dto.request.services.DepositsRequest;
import com.bankproject.bank.dto.request.services.ExtractionsRequest;
import com.bankproject.bank.dto.request.services.FixedTermRequest;
import com.bankproject.bank.dto.request.services.LoanRequest;
import com.bankproject.bank.dto.response.services.FixedTermInfoResponse;
import com.bankproject.bank.dto.response.services.LoanInfoResponse;
import com.bankproject.bank.dto.services.*;

import java.util.List;

public interface IServicesService {


    ServicesDTO CreateOneService(ServicesDTO servicesDTO);

    LoanDTO createOneLoan(LoanRequest loanRequest);

    DepositsDTO createOneDeposit(DepositsDTO depositsDTO);


    ExtractionsDTO createOneExtraction(ExtractionsDTO extractionsDTO);

    FixedTermDTO createOneFixedTerm(FixedTermRequest fixedTermDTO);

    List<LoanDTO> getAllLoan();

    LoanInfoResponse loanInfo();

    FixedTermInfoResponse fixedTermInfo();

    void associateServiceWithAccount(AccountDTO accountDTO, ServicesDTO servicesDTO);


}
