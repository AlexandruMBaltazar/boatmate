package com.amb.identityservice.account.validation;

import com.amb.identityservice.account.validation.annotation.Unique;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UniqueValidator implements ConstraintValidator<Unique, String> {

    private Class<?> entityClass;
    private String fieldName;
    private final UniqueValidatorFactory uniqueValidatorFactory;

    public UniqueValidator(UniqueValidatorFactory uniqueValidatorFactory) {
        this.uniqueValidatorFactory = uniqueValidatorFactory;
    }

    @Override
    public void initialize(Unique constraintAnnotation) {
        this.entityClass = constraintAnnotation.entityClass();
        this.fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(
        String value,
        ConstraintValidatorContext context
    ) {
        if (value == null) {
            return true;
        }

        var validator = uniqueValidatorFactory.createValidator(entityClass);
        return !validator.validate(fieldName, value);
    }
}
