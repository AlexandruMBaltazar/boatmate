package com.amb.identityservice.account.validation;

public interface UniqueValidatorStrategy {
    boolean validate(String property, String value);
}
