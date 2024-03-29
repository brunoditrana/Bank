package com.bankproject.bank.service;

import com.bankproject.bank.adapter.ProfileAdapter;
import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.dto.request.ProfileUpdateRequest;
import com.bankproject.bank.dto.request.services.DepositsRequest;
import com.bankproject.bank.dto.request.services.ExtractionsRequest;
import com.bankproject.bank.dto.request.services.FixedTermRequest;
import com.bankproject.bank.dto.request.services.LoanRequest;
import com.bankproject.bank.dto.response.ProfileResponse;
import com.bankproject.bank.dto.response.services.DepositsResponse;
import com.bankproject.bank.dto.response.services.ExtractionsResponse;
import com.bankproject.bank.dto.response.services.FixedTermResponse;
import com.bankproject.bank.dto.response.services.LoanResponse;
import com.bankproject.bank.dto.services.*;
import com.bankproject.bank.entity.Enum.Role;
import com.bankproject.bank.mapper.ProfileMapper;
import com.bankproject.bank.mapper.ServicesMapper;
import com.bankproject.bank.mapper.services.DepositsMapper;
import com.bankproject.bank.mapper.services.ExtractionsMapper;
import com.bankproject.bank.mapper.services.FixedTermMapper;
import com.bankproject.bank.mapper.services.LoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class ProfileService implements IProfileService{

    @Autowired
    private ProfileAdapter profileAdapter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private  IServicesService servicesService;

    @Autowired
    private  IAccountService accountService;


    public ProfileDTO createProfile(ProfileDTO profileDTO){

        ProfileDTO profDTO = new ProfileDTO();

        profDTO.setUsername(profileDTO.getUsername());
        profDTO.setPassword(passwordEncoder.encode(profileDTO.getPassword()));
        profDTO.setName(profileDTO.getName());
        profDTO.setLastName(profileDTO.getLastName());
        profDTO.setRole(Role.CUSTOMER);

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setProfile(profileDTO);

        accountService.createOneAccount(accountDTO);


      return profileAdapter.save(profDTO);

    }


    @Override
    public ProfileUserDetailsService findByUsernameDetails(String username) {

        return profileAdapter.findByUsernameDetails(username);

    }
    @Override
    public ProfileDTO findByUsername(String username) {

        return profileAdapter.findByUsername(username);

    }

    @Override
    public ProfileResponse updateProfile(ProfileUpdateRequest request) {

        ProfileDTO profileDTO = findByUsername(request.getUsername());

        //Validar que no sea null

        profileDTO.setUsername(request.getUsername());
        profileDTO.setPassword(request.getPassword());
        profileDTO.setName(request.getName());
        profileDTO.setLastName(request.getLastName());
        profileDTO.setRole(request.getRole());

        profileAdapter.save(profileDTO);

        return ProfileMapper.INSTANCE.toResponse(profileDTO);
    }

    @Override
    public String deleteProfile(String username) {

        ProfileDTO profileDTO = findByUsername( username);

        profileAdapter.deleteProfile(profileDTO.getUsername());

        return "Profile deleted successfully";
    }

    @Override
    public DepositsResponse processDeposit(String username, DepositsRequest req) {

        validateProfile(username);

        ProfileDTO profDTO = findByUsername(username);

        ServicesDTO servicesDTO = new ServicesDTO();
        servicesDTO.setServiceName("Deposit");
        servicesDTO.setDescription("Deposit service for bank accounts");

        DepositsDTO depositsDTO = new DepositsDTO();

        AccountDTO accountDTO = accountService.findByIdAccount(profDTO.getAccount().getIdAccount());

        servicesService.associateServiceWithAccount(accountDTO,servicesDTO);

        BigDecimal depositAmount = req.getAmount();
        BigDecimal currentBalance = accountDTO.getBalance();
        BigDecimal newBalance = currentBalance.add(depositAmount);

        accountDTO.setBalance(newBalance);

        depositsDTO.setAmount(depositAmount);
        depositsDTO.setDepositDate(req.getDepositDate());
        depositsDTO.setServices(servicesDTO);
        depositsDTO.setAccount(accountDTO);

        servicesService.createOneDeposit(depositsDTO);

        return DepositsMapper.INSTANCE.toResponse(depositsDTO);
    }

    @Override
    public ExtractionsResponse processExtraction(String username, ExtractionsRequest ext) {

        validateProfile(username);

        ProfileDTO profDTO = findByUsername(username);

        ServicesDTO servicesDTO = new ServicesDTO();
        servicesDTO.setServiceName("Extractions");
        servicesDTO.setDescription("Extraction service for account withdrawals");

        ExtractionsDTO extractionsDTO = new ExtractionsDTO();

        AccountDTO accountDTO = accountService.findByIdAccount(profDTO.getAccount().getIdAccount());

        servicesService.associateServiceWithAccount(accountDTO,servicesDTO);

        BigDecimal extractionAmount = ext.getAmount();
        BigDecimal currentBalance = accountDTO.getBalance();

        if (currentBalance.compareTo(extractionAmount) < 0){
            //EXCEPTION si el saldo que tenogo es menor al que quoeir agregar
        }

        BigDecimal newBalance = currentBalance.subtract(extractionAmount);
        accountDTO.setBalance(newBalance);

        extractionsDTO.setAmount(extractionAmount);
        extractionsDTO.setAccount(accountDTO);
        extractionsDTO.setServices(servicesDTO);

        servicesService.createOneExtraction(extractionsDTO);


        return ExtractionsMapper.INSTANCE.toResponse(extractionsDTO);
    }

    @Override
    public LoanResponse processLoan(String username, LoanRequest loan) {

        validateProfile(username);

        ProfileDTO profDTO = findByUsername(username);

        ServicesDTO servicesDTO = new ServicesDTO();
        servicesDTO.setServiceName("Loan");
        servicesDTO.setDescription("Loan service for financial assistance, with competitive interest rates and flexible repayment options.");

        LoanDTO loanDTO = new LoanDTO();

        AccountDTO accountDTO = accountService.findByIdAccount(profDTO.getAccount().getIdAccount());

        servicesService.associateServiceWithAccount(accountDTO,servicesDTO);

        BigDecimal loanAmount = loan.getTotalLoanAmount();
        Double interestRate = loan.getInterestRate();
        Integer numberOfInstallments = loan.getNumberOfInstallments();


        BigDecimal monthlyPayment = calculateMonthlyPayment(loanAmount,interestRate,numberOfInstallments);

        BigDecimal currentBalance = accountDTO.getBalance();



        BigDecimal newBalance = currentBalance.add(loanAmount);

        accountDTO.setBalance(newBalance);

        loanDTO.setInterestRate(interestRate);
        loanDTO.setNumberOfInstallments(numberOfInstallments);
        loanDTO.setTotalLoanAmount(loanAmount);
        loanDTO.setMonthlyPayment(monthlyPayment);

        loanDTO.setDate(LocalDate.now());
        loanDTO.setAccount(accountDTO);
        loanDTO.setServices(servicesDTO);

        servicesService.createOneLoan(loanDTO);


        return LoanMapper.INSTANCE.toResponse(loanDTO);
    }

    @Override
    public FixedTermResponse processFixedTerm(String username, FixedTermRequest fixedTermRequest) {


        validateProfile(username);

        ProfileDTO profDTO = findByUsername(username);

        ServicesDTO servicesDTO = new ServicesDTO();
        servicesDTO.setServiceName("FixedTerm ");
        servicesDTO.setDescription("FixedTerm deposit service with competitive interest rates and flexible duration options.");

        FixedTermDTO fixedTermDTO = new FixedTermDTO();

        AccountDTO accountDTO = accountService.findByIdAccount(profDTO.getAccount().getIdAccount());

        servicesService.associateServiceWithAccount(accountDTO,servicesDTO);

        BigDecimal extractionAmount = fixedTermRequest.getAmount();
        BigDecimal currentBalance = accountDTO.getBalance();

        if (currentBalance.compareTo(extractionAmount) < 0){
            //EXCEPTION si el saldo que tenogo es menor al que quoeir agregar
        }

        BigDecimal newBalance = currentBalance.subtract(extractionAmount);

        Double interestRate = fixedTermRequest.getInterestRate();
        int numberOfMonths = fixedTermRequest.getFixedTermDurationEnum().getMonths();
        BigDecimal monthlyInterestRate = BigDecimal.valueOf(interestRate / 100 / 12);

        BigDecimal monthlyPayment = calculateMonthlyPaymentFixedTerm(extractionAmount, monthlyInterestRate, numberOfMonths);


        accountDTO.setBalance(newBalance);

        fixedTermDTO.setInterestRate(interestRate);
        fixedTermDTO.setAmount(extractionAmount);
        fixedTermDTO.setDate(LocalDate.now());
        fixedTermDTO.setFixedTermDurationEnum(fixedTermRequest.getFixedTermDurationEnum());
        fixedTermDTO.setMonthlyPayment(monthlyPayment);
        fixedTermDTO.setServices(servicesDTO);
        fixedTermDTO.setAccount(accountDTO);


        servicesService.createOneFixedTerm(fixedTermDTO);

        return FixedTermMapper.INSTANCE.toResponse(fixedTermDTO);
    }

    private BigDecimal calculateMonthlyPaymentFixedTerm(BigDecimal extractionAmount, BigDecimal monthlyInterestRate, int numberOfMonths) {
        BigDecimal factor = monthlyInterestRate.add(BigDecimal.ONE).pow(numberOfMonths);
        factor = factor.subtract(BigDecimal.ONE).divide(monthlyInterestRate.multiply(factor), 2, RoundingMode.HALF_UP);
        BigDecimal monthlyPayment = extractionAmount.multiply(monthlyInterestRate).divide(factor, 2, RoundingMode.HALF_UP);
        return monthlyPayment;
    }


    public boolean validateProfile(String username){

        ProfileDTO profDTO = profileAdapter.findByUsername(username);

        if (profDTO == null){
            //Exepctions
        }
        return true;
    }

    public BigDecimal calculateMonthlyPayment(BigDecimal loanAmount, double interestRate, int numberOfInstallments) {

        BigDecimal monthlyInterestRate = BigDecimal.valueOf(interestRate / 100 / 12);


        BigDecimal factor = monthlyInterestRate.add(BigDecimal.ONE).pow(numberOfInstallments);
        factor = factor.subtract(BigDecimal.ONE).divide(monthlyInterestRate.multiply(factor), 2, RoundingMode.HALF_UP);


        BigDecimal monthlyPayment = loanAmount.multiply(monthlyInterestRate).divide(factor, 2, RoundingMode.HALF_UP);

        return monthlyPayment;
    }

}
