package com.amb.commonservice.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record GlobalApiError(
    String message,
    Map<String, String> validationErrors
) {
}
