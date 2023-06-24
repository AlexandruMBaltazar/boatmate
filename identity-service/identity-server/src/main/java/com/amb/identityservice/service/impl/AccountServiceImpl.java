package com.amb.identityservice.service.impl;

import com.amb.identityservice.account.dto.AccountRequest;
import com.amb.identityservice.account.dto.AccountResponse;
import com.amb.identityservice.mapper.AccountMapper;
import com.amb.identityservice.repository.AccountRepository;
import com.amb.identityservice.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountMapper accountMapper,
        AccountRepository accountRepository
    ) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponse createAccount(AccountRequest accountRequest) {
        var account = accountMapper.accountRequestToAccount(accountRequest);
        return accountMapper.accountToAccountResponse(accountRepository.save(account));
    }
}
