package com.amb.identityservice.account.validation;

import org.springframework.data.jpa.domain.Specification;

public class UniqueSpecification {
    public static <T> Specification<T> hasPropertyWithValue(String propertyName, String propertyValue) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(propertyName), propertyValue);
    }
 }
