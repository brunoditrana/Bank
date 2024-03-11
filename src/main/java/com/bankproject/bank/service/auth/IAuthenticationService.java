package com.bankproject.bank.service.auth;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.dto.request.AuthenticationResponse;
import com.bankproject.bank.dto.request.ProfileRequest;
import com.bankproject.bank.dto.response.AuthenticationRequest;
import com.bankproject.bank.dto.response.ProfileResponse;

public interface IAuthenticationService {

    ProfileUserDetailsService registerOneCustomer(ProfileRequest request);

    AuthenticationResponse login(AuthenticationRequest authenticationRequest);

    boolean validateToken(String jwt);
}
