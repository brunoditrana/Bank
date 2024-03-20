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

    @Value("${fixed-term.default-interest-rate}")
    private Double interestRate;

    @Value("${fixed-term.default-minimum-amount}")
    private BigDecimal minimumAmount;

    @Override
    public ServicesDTO CreateOneService(ServicesDTO servicesDTO) {

        ServicesDTO serDTO = new ServicesDTO();
        serDTO.setServiceName(servicesDTO.getServiceName());
        serDTO.setDescription(servicesDTO.getDescription());


        return servicesAdapter.CreateOneService(servicesDTO);
    }

    @Override
    public LoanDTO createOneLoan(LoanRequest loanRequest) {

        //Validar entrada
        LoanDTO loanDTO = new LoanDTO();

        loanDTO.setInterestRate(defaultInterestRate);
        loanDTO.setMaximumAmount(defaultMaximumAmount);
        loanDTO.setAmount(new BigDecimal(0));
        loanDTO.setDate(loanRequest.getDate());

        return servicesAdapter.createOneLoan(loanDTO);

    }

    @Override
    public DepositsDTO createOneDeposit(DepositsDTO depositsDTO) {
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

        dto.setInterestRate(interestRate);
        dto.setMinimumAmount(minimumAmount);
        dto.setAmount(fixedTermDTO.getAmount());
        dto.setDate(fixedTermDTO.getDate());
        dto.setFixedTermDurationEnum(fixedTermDTO.getFixedTermDurationEnum());

        return  servicesAdapter.createOneFixedTerm(dto);

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
        f.setInterestRate(interestRate);
        f.setMinimumAmount(minimumAmount);

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
