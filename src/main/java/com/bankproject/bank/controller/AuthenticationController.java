package com.bankproject.bank.controller;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.dto.request.ProfileRequest;
import com.bankproject.bank.dto.response.ProfileResponse;
import com.bankproject.bank.mapper.ProfileMapper;
import com.bankproject.bank.service.auth.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authService;


    @PostMapping
    private ResponseEntity<ProfileResponse> createProfile(@RequestBody ProfileRequest profileRequest){

        ProfileUserDetailsService response = authService.registerOneCustomer(profileRequest);

        return null;
                //ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
