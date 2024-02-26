package com.bankproject.bank.controller;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.request.ProfileRequest;
import com.bankproject.bank.dto.response.ProfileResponse;
import com.bankproject.bank.mapper.ProfileMapper;
import com.bankproject.bank.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class ProfileController {


    @Autowired
    private IProfileService profileService;

    @PostMapping
    private ResponseEntity<ProfileResponse> createProfile(@RequestBody ProfileRequest profileRequest){

        ProfileDTO profileDTO = profileService.createProfile(ProfileMapper.INSTANCE.toDTO(profileRequest));

        return  ResponseEntity.status(HttpStatus.CREATED).body(ProfileMapper.INSTANCE.toResponse(profileDTO));
    }
}
