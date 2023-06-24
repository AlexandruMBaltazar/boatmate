package com.amb.commonservice.validation;

public interface UniqueValidatorStrategy {
    boolean validate(String property, String value);
}
