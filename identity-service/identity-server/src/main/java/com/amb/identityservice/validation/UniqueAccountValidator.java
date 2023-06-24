package com.amb.identityservice.validation;


import com.amb.commonservice.validation.UniqueSpecification;
import com.amb.commonservice.validation.UniqueValidatorStrategy;
import com.amb.identityservice.repository.AccountRepository;
import org.springframework.stereotype.Component;

@Component
public class UniqueAccountValidator implements UniqueValidatorStrategy {

    private final AccountRepository accountRepository;

    public UniqueAccountValidator(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean validate(
        String property,
        String value
    ) {
        return accountRepository.exists(UniqueSpecification.hasPropertyWithValue(property, value));
    }
}
