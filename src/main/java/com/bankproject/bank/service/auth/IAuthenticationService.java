package com.bankproject.bank.service.auth;

import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.dto.request.AuthenticationResponse;
import com.bankproject.bank.dto.request.ProfileRequest;
import com.bankproject.bank.dto.request.AuthenticationRequest;

public interface IAuthenticationService {

    ProfileUserDetailsService registerOneCustomer(ProfileRequest request);

    AuthenticationResponse login(AuthenticationRequest authenticationRequest);

    boolean validateToken(String jwt);
}
