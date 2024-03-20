package com.bankproject.bank.service;

import com.bankproject.bank.adapter.ProfileAdapter;
import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.dto.request.services.DepositsRequest;
import com.bankproject.bank.dto.response.services.DepositsResponse;
import com.bankproject.bank.dto.services.DepositsDTO;
import com.bankproject.bank.dto.services.ServicesDTO;
import com.bankproject.bank.entity.Enum.Role;
import com.bankproject.bank.mapper.ProfileMapper;
import com.bankproject.bank.mapper.ServicesMapper;
import com.bankproject.bank.mapper.services.DepositsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    @Value("${service.deposit.name}")
    private String depositServiceName;

    @Value("${service.deposit.description}")
    private String depositServiceDescription;

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
        servicesDTO.setDescription(depositServiceDescription);
        servicesDTO.setServiceName(depositServiceName);

        DepositsDTO depositsDTO = new DepositsDTO();

        AccountDTO accountDTO = accountService.findByIdAccount(profDTO.getAccount().getIdAccount());

        servicesService.associateServiceWithAccount(accountDTO,servicesDTO);

        depositsDTO.setAmount(req.getAmount());
        depositsDTO.setDepositDate(req.getDepositDate());
        depositsDTO.setServices(servicesDTO);
        depositsDTO.setAccount(accountDTO);

        servicesService.createOneDeposit(depositsDTO);

        return DepositsMapper.INSTANCE.toResponse(depositsDTO);
    }


    public boolean validateProfile(String username){

        ProfileDTO profDTO = profileAdapter.findByUsername(username);

        if (profDTO == null){
            //Exepctions
        }
        return true;
    }

}
