package com.bankproject.bank.controller;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.dto.request.ProfileRequest;
import com.bankproject.bank.dto.request.services.DepositsRequest;
import com.bankproject.bank.dto.response.ProfileResponse;
import com.bankproject.bank.dto.response.services.DepositsResponse;
import com.bankproject.bank.mapper.ProfileMapper;
import com.bankproject.bank.service.IProfileService;
import com.bankproject.bank.service.auth.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class ProfileController {

    @Autowired
    private IAuthenticationService authService;

    @Autowired
    private IProfileService profileService;


   // @PreAuthorize("permiteAll")
    //@PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @PreAuthorize("hasAuthority('CREATE_PROFILE')")
    @PostMapping
    public ResponseEntity<ProfileResponse> createProfile(@RequestBody ProfileRequest profileRequest){

        ProfileUserDetailsService response = authService.registerOneCustomer(profileRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(ProfileMapper.INSTANCE.toResponse(response));
    }

    @GetMapping("/{username}")
    public ResponseEntity<ProfileResponse> findByUsername(@PathVariable String username){

        ProfileDTO profileDTO = profileService.findByUsername(username);

        return ResponseEntity.status(HttpStatus.CREATED).body(ProfileMapper.INSTANCE.toResponse(profileDTO));

    }

    @PostMapping("/deposit/{username}")
    public  ResponseEntity<DepositsResponse> processDeposit(@PathVariable String username, @RequestBody DepositsRequest dep){

        DepositsResponse depositsResponse = profileService.processDeposit(username, dep);

        return  ResponseEntity.ok().body(depositsResponse);
    }

}
