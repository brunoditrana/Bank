package com.bankproject.bank.controller;

import com.bankproject.bank.dto.request.AuthenticationResponse;
import com.bankproject.bank.dto.response.AuthenticationRequest;

import com.bankproject.bank.service.auth.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestParam String jwt){

        boolean isValidate = authenticationService.validateToken(jwt);

        return ResponseEntity.ok(isValidate);
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest authenticationRequest){

        AuthenticationResponse response = authenticationService.login(authenticationRequest);

        return ResponseEntity.ok(response);

    }
}
