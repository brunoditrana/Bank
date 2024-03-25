package com.bankproject.bank.controller;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.dto.request.ProfileRequest;
import com.bankproject.bank.dto.request.ProfileUpdateRequest;
import com.bankproject.bank.dto.request.services.DepositsRequest;
import com.bankproject.bank.dto.request.services.ExtractionsRequest;
import com.bankproject.bank.dto.request.services.FixedTermRequest;
import com.bankproject.bank.dto.request.services.LoanRequest;
import com.bankproject.bank.dto.response.ProfileResponse;
import com.bankproject.bank.dto.response.services.DepositsResponse;
import com.bankproject.bank.dto.response.services.ExtractionsResponse;
import com.bankproject.bank.dto.response.services.FixedTermResponse;
import com.bankproject.bank.dto.response.services.LoanResponse;
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

    @PutMapping("/")
    public  ResponseEntity<ProfileResponse> updateProfile(@RequestBody ProfileUpdateRequest request){

        ProfileResponse response = profileService.updateProfile(request);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{username}")
    public  ResponseEntity<String> deleteProfile(@PathVariable String username){

        String response = profileService.deleteProfile(username);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/deposit/{username}")
    public  ResponseEntity<DepositsResponse> processDeposit(@PathVariable String username, @RequestBody DepositsRequest dep){

        DepositsResponse depositsResponse = profileService.processDeposit(username, dep);


        return  ResponseEntity.ok().body(depositsResponse);
    }

    @PostMapping("/extraction/{username}")
    public  ResponseEntity<ExtractionsResponse> processExtractions(@PathVariable String username, @RequestBody ExtractionsRequest ext) {

        ExtractionsResponse extractionsResp = profileService.processExtraction(username,ext);

        return ResponseEntity.ok().body(extractionsResp);

    }
    @PostMapping("/loan/{username}")
    public ResponseEntity<LoanResponse> processLoan(@PathVariable String username, @RequestBody LoanRequest loan){

        LoanResponse loanResponse = profileService.processLoan(username, loan);
        loanResponse.setMessage("Loan processed successfully");

        return ResponseEntity.ok().body(loanResponse);

    }

    @PostMapping("/fixedTerm/{username}")
    public ResponseEntity<FixedTermResponse> processFixedTerm(@PathVariable String username, @RequestBody FixedTermRequest request){

        FixedTermResponse response = profileService.processFixedTerm(username, request);

        return ResponseEntity.ok().body(response);
    }


}
