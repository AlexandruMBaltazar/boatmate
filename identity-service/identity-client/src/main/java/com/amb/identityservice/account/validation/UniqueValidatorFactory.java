package com.amb.identityservice.account.validation;

public interface UniqueValidatorFactory {
    UniqueValidatorStrategy createValidator(Class<?> entity);
}
