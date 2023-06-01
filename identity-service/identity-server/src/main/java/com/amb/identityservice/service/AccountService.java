package com.amb.identityservice.service;

import com.amb.identityservice.account.dto.AccountRequest;
import com.amb.identityservice.account.dto.AccountResponse;

public interface AccountService {
    AccountResponse createAccount(AccountRequest accountRequest);
}
