package com.amb.identityservice.controller;

import com.amb.identityservice.account.dto.request.AccountRequest;
import com.amb.identityservice.account.dto.request.AuthenticationRequest;
import com.amb.identityservice.account.dto.response.AuthenticationResponse;
import com.amb.identityservice.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public record AccountController(AccountService accountService) {
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> createAccount(@Valid @RequestBody AccountRequest accountRequest) {
        return new ResponseEntity<>(accountService.createAccount(accountRequest), HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(accountService.authenticate(authenticationRequest));
    }
}
