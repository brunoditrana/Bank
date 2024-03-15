package com.bankproject.bank.controller;

import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.dto.request.ProfileRequest;
import com.bankproject.bank.dto.response.ProfileResponse;
import com.bankproject.bank.mapper.ProfileMapper;
import com.bankproject.bank.service.auth.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class ProfileController {

    @Autowired
    private IAuthenticationService authService;


   // @PreAuthorize("permiteAll")
    //@PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @PreAuthorize("hasAuthority('CREATE_PROFILE')")
    @PostMapping
    private ResponseEntity<ProfileResponse> createProfile(@RequestBody ProfileRequest profileRequest){

        ProfileUserDetailsService response = authService.registerOneCustomer(profileRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(ProfileMapper.INSTANCE.toResponse(response));
    }
}
