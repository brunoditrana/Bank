package com.bankproject.bank.service;

import com.bankproject.bank.adapter.AccountServiceAdapter;
import com.bankproject.bank.adapter.ServicesAdapter;
import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.dto.AccountServiceDTO;
import com.bankproject.bank.dto.request.services.ExtractionsRequest;
import com.bankproject.bank.dto.request.services.FixedTermRequest;
import com.bankproject.bank.dto.request.services.LoanRequest;
import com.bankproject.bank.dto.response.services.FixedTermInfoResponse;
import com.bankproject.bank.dto.response.services.LoanInfoResponse;
import com.bankproject.bank.dto.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ServicesService implements IServicesService{

    @Autowired
    private ServicesAdapter servicesAdapter;

    @Autowired
    private AccountServiceAdapter accountServiceAdapter;

    @Value("${loan.default-interest-rate}")
    private Double defaultInterestRate;

    @Value("${loan.default-maximum-amount}")
    private BigDecimal defaultMaximumAmount;


    @Override
    public ServicesDTO CreateOneService(ServicesDTO servicesDTO) {

        ServicesDTO serDTO = new ServicesDTO();
        serDTO.setServiceName(servicesDTO.getServiceName());
        serDTO.setDescription(servicesDTO.getDescription());


        return servicesAdapter.CreateOneService(servicesDTO);
    }

    @Override
    public LoanDTO createOneLoan(LoanDTO loanDTO) {



        return servicesAdapter.createOneLoan(loanDTO);

    }

    @Override
    public DepositsDTO createOneDeposit(DepositsDTO depositsDTO) {
        return servicesAdapter.createOneDeposit(depositsDTO);

    }

    @Override
    public ExtractionsDTO createOneExtraction(ExtractionsDTO extractDTO) {

        return servicesAdapter.createOneExtraction(extractDTO);
    }

    @Override
    public FixedTermDTO createOneFixedTerm(FixedTermDTO fixedTermDTO) {


        return  servicesAdapter.createOneFixedTerm(fixedTermDTO);

    }

    @Override
    public List<LoanDTO> getAllLoan() {

        return servicesAdapter.getAllLoan();
    }

    @Override
    public LoanInfoResponse loanInfo() {

        LoanInfoResponse l = new LoanInfoResponse();
        l.setMaximumAmount(defaultMaximumAmount);
        l.setInterestRate(defaultInterestRate);
        return l;
    }

    @Override
    public FixedTermInfoResponse fixedTermInfo() {

        FixedTermInfoResponse f = new FixedTermInfoResponse();
      //  f.setInterestRate(interestRate);
        //f.setMinimumAmount(minimumAmount);

        return null;
    }

    @Override
    public void associateServiceWithAccount(AccountDTO accountDTO, ServicesDTO servicesDTO) {

        AccountServiceDTO accountServiceDTO = new AccountServiceDTO();
        accountServiceDTO.setAccount(accountDTO);
        accountServiceDTO.setServices(servicesDTO);

        accountServiceAdapter.save(accountServiceDTO);
    }


}
