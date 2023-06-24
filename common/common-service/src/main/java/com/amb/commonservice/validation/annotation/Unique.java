package com.amb.commonservice.validation.annotation;

import com.amb.commonservice.validation.UniqueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface Unique {
    String message() default "This field must be unique";

    Class<?> entityClass();

    String fieldName();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
