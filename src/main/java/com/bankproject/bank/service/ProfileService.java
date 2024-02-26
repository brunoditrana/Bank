package com.bankproject.bank.service;

import com.bankproject.bank.adapter.ProfileAdapter;
import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.response.ProfileResponse;
import com.bankproject.bank.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService implements IProfileService{

    @Autowired
    private ProfileAdapter profileAdapter;

    public ProfileDTO createProfile(ProfileDTO profileDTO){

      return profileAdapter.save(profileDTO);


    }

}
