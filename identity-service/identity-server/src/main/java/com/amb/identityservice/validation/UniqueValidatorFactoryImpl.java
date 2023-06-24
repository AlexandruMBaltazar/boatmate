package com.amb.identityservice.validation;

import com.amb.identityservice.account.model.Account;
import com.amb.identityservice.account.validation.UniqueValidatorFactory;
import com.amb.identityservice.account.validation.UniqueValidatorStrategy;
import com.amb.identityservice.repository.AccountRepository;
import org.springframework.stereotype.Component;

@Component
public class UniqueValidatorFactoryImpl implements UniqueValidatorFactory {

    private final AccountRepository accountRepository;

    public UniqueValidatorFactoryImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public UniqueValidatorStrategy createValidator(Class<?> entity) {
        if (entity.equals(Account.class)) {
            return new UniqueAccountValidator(accountRepository);
        }

        throw new IllegalArgumentException("No validator can be found for the given entity");
    }

}
