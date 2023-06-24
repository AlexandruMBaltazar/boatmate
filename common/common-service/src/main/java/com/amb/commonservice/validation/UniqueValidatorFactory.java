package com.amb.commonservice.validation;

public interface UniqueValidatorFactory {
    UniqueValidatorStrategy createValidator(Class<?> entity);
}
