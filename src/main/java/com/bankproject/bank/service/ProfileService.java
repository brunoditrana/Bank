package com.bankproject.bank.service;

import com.bankproject.bank.adapter.ProfileAdapter;
import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.dto.request.services.DepositsRequest;
import com.bankproject.bank.dto.request.services.ExtractionsRequest;
import com.bankproject.bank.dto.response.services.DepositsResponse;
import com.bankproject.bank.dto.response.services.ExtractionsResponse;
import com.bankproject.bank.dto.services.DepositsDTO;
import com.bankproject.bank.dto.services.ExtractionsDTO;
import com.bankproject.bank.dto.services.ServicesDTO;
import com.bankproject.bank.entity.Enum.Role;
import com.bankproject.bank.mapper.ProfileMapper;
import com.bankproject.bank.mapper.ServicesMapper;
import com.bankproject.bank.mapper.services.DepositsMapper;
import com.bankproject.bank.mapper.services.ExtractionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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


    public boolean validateProfile(String username){

        ProfileDTO profDTO = profileAdapter.findByUsername(username);

        if (profDTO == null){
            //Exepctions
        }
        return true;
    }

}
