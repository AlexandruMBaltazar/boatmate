package com.amb.identityservice.service;

import com.amb.identityservice.account.dto.request.AccountRequest;
import com.amb.identityservice.account.dto.request.AuthenticationRequest;
import com.amb.identityservice.account.dto.response.AuthenticationResponse;

public interface AccountService {
    AuthenticationResponse createAccount(AccountRequest accountRequest);

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
