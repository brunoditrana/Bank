package com.bankproject.bank.service;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.dto.request.services.DepositsRequest;
import com.bankproject.bank.dto.request.services.ExtractionsRequest;
import com.bankproject.bank.dto.request.services.FixedTermRequest;
import com.bankproject.bank.dto.request.services.LoanRequest;
import com.bankproject.bank.dto.response.ProfileResponse;
import com.bankproject.bank.dto.response.services.DepositsResponse;
import com.bankproject.bank.dto.response.services.ExtractionsResponse;
import com.bankproject.bank.dto.response.services.FixedTermResponse;
import com.bankproject.bank.dto.response.services.LoanResponse;

import java.math.BigDecimal;

public interface IProfileService {

    ProfileDTO createProfile(ProfileDTO profileDTO);

    ProfileDTO findByUsername(String username);


    DepositsResponse processDeposit(String username, DepositsRequest req);

    ExtractionsResponse processExtraction(String username, ExtractionsRequest ext);

    LoanResponse processLoan(String username, LoanRequest loan);

    FixedTermResponse processFixedTerm(String username, FixedTermRequest fixedTermReque);

    ProfileUserDetailsService findByUsernameDetails(String username);

    BigDecimal calculateMonthlyPayment(BigDecimal loanAmount, double interestRate, int numberOfInstallments);
}
