package com.bankproject.bank.service;

import com.bankproject.bank.adapter.ProfileAdapter;
import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.request.services.DepositsRequest;
import com.bankproject.bank.dto.response.services.DepositsResponse;
import com.bankproject.bank.dto.services.DepositsDTO;
import com.bankproject.bank.dto.services.ServicesDTO;
import com.bankproject.bank.entity.Enum.Role;
import com.bankproject.bank.mapper.ProfileMapper;
import com.bankproject.bank.mapper.ServicesMapper;
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


      return profileAdapter.save(profDTO);

    }

    @Override
    public ProfileDTO findByUsername(String username) {

        return ProfileMapper.INSTANCE.toDTO( profileAdapter.findByUsernameDetails(username));

    }

    @Override
    public DepositsResponse processDeposit(String username, DepositsRequest req) {

        boolean valid = validateProfile(username);

        ProfileDTO profDTO = findByUsername(username);

        ServicesDTO servicesDTO = new ServicesDTO();
        servicesDTO.setDescription(depositServiceDescription);
        servicesDTO.setServiceName(depositServiceName);

        DepositsDTO depositsDTO = new DepositsDTO();


        depositsDTO.setAmount(req.getAmount());
        depositsDTO.setDepositDate(req.getDepositDate());
        depositsDTO.setAccount(profDTO.getAccount());
        depositsDTO.setServices(ServicesMapper.INSTANCE.toEntity(servicesDTO));

        servicesService.createOneDeposit(depositsDTO);
        return null;
    }


    public boolean validateProfile(String username){

        ProfileDTO profDTO = profileAdapter.findByUsername(username);

        if (profDTO == null){
            //Exepctions
        }
        return true;
    }

}
