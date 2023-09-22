package com.amb.identityservice.service.impl;

import com.amb.identityservice.account.dto.request.AccountRequest;
import com.amb.identityservice.account.dto.request.AuthenticationRequest;
import com.amb.identityservice.account.dto.response.AuthenticationResponse;
import com.amb.identityservice.config.JwtService;
import com.amb.identityservice.mapper.AccountMapper;
import com.amb.identityservice.repository.AccountRepository;
import com.amb.identityservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse createAccount(AccountRequest accountRequest) {
        var account = accountMapper.accountRequestToAccount(accountRequest);
        accountMapper.accountToAccountResponse(accountRepository.save(account));

        return new AuthenticationResponse(jwtService.generateToken(account));
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                authenticationRequest.email(),
                authenticationRequest.password()
            )
        );

        var account = accountRepository.findByEmail(authenticationRequest.email())
            .orElseThrow();

        return new AuthenticationResponse(jwtService.generateToken(account));
    }
}
