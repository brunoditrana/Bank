package com.bankproject.bank.service;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.response.ProfileResponse;

public interface IProfileService {

    ProfileDTO createProfile(ProfileDTO profileDTO);

    ProfileDTO findByUsername(String username);
}
