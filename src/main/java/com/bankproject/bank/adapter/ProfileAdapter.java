package com.bankproject.bank.adapter;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.ProfileUserDetailsService;

public interface ProfileAdapter {

    ProfileUserDetailsService findByUsernameDetails(String username);


    ProfileDTO findByUsername(String username);

    ProfileDTO save(ProfileDTO profileDTO);

}
