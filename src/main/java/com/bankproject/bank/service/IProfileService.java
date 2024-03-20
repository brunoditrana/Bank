package com.bankproject.bank.service;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.dto.request.services.DepositsRequest;
import com.bankproject.bank.dto.response.ProfileResponse;
import com.bankproject.bank.dto.response.services.DepositsResponse;

public interface IProfileService {

    ProfileDTO createProfile(ProfileDTO profileDTO);

    ProfileDTO findByUsername(String username);


    DepositsResponse processDeposit(String username, DepositsRequest req);

    ProfileUserDetailsService findByUsernameDetails(String username);
}
