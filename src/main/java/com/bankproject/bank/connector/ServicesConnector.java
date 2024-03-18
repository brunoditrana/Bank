package com.bankproject.bank.connector;

import com.bankproject.bank.adapter.ServicesAdapter;
import com.bankproject.bank.dto.services.DepositsDTO;
import com.bankproject.bank.dto.services.ExtractionsDTO;
import com.bankproject.bank.dto.services.FixedTermDTO;
import com.bankproject.bank.dto.services.LoanDTO;
import com.bankproject.bank.entity.services.Deposits;
import com.bankproject.bank.entity.services.Extractions;
import com.bankproject.bank.entity.services.FixedTerm;
import com.bankproject.bank.entity.services.Loan;
import com.bankproject.bank.mapper.services.DepositsMapper;
import com.bankproject.bank.mapper.services.ExtractionsMapper;
import com.bankproject.bank.mapper.services.FixedTermMapper;
import com.bankproject.bank.mapper.services.LoanMapper;
import com.bankproject.bank.repository.ServicesRepository;
import com.bankproject.bank.repository.services.DepositsRepository;
import com.bankproject.bank.repository.services.ExtractionsRepository;
import com.bankproject.bank.repository.services.FixedTermRepository;
import com.bankproject.bank.repository.services.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesConnector implements ServicesAdapter {

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private DepositsRepository depositsRepository;

    @Autowired
    private ExtractionsRepository extractionsRepository;

    @Autowired
    private FixedTermRepository fixedTermRepository;

    @Override
    public LoanDTO createOneLoan(LoanDTO loanDTO) {

        Loan loan = loanRepository.save(LoanMapper.INSTANCE.toEntity(loanDTO));

        return LoanMapper.INSTANCE.toDTO(loan);
    }

    @Override
    public DepositsDTO createOneDeposit(DepositsDTO dto) {

        Deposits deposits = depositsRepository.save(DepositsMapper.INSTANCE.toEntity(dto));

        return DepositsMapper.INSTANCE.toDTO(deposits);
    }

    @Override
    public ExtractionsDTO createOneExtraction(ExtractionsDTO extractionsDTO) {

        Extractions extractions = extractionsRepository.save(ExtractionsMapper.INSTANCE.toEntity(extractionsDTO));

        return ExtractionsMapper.INSTANCE.toDTO(extractions);

    }

    @Override
    public FixedTermDTO createOneFixedTerm(FixedTermDTO dto) {

        FixedTerm fixed = fixedTermRepository.save(FixedTermMapper.INSTANCE.toEntity(dto));

        return FixedTermMapper.INSTANCE.toDTO(fixed);

    }
}
