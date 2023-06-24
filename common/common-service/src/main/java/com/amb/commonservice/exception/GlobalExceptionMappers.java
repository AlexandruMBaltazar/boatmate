package com.amb.commonservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionMappers extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatusCode status,
        WebRequest request
    ) {
        Map<String, String> validationErrors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
            .forEach(fieldError -> validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage()));

        GlobalApiError userGlobalException = new GlobalApiError(
            "Some of your fields are wrong",
            validationErrors
        );

        return new ResponseEntity<>(userGlobalException, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = {GlobalApiRequestException.class})
    public ResponseEntity<Object> handleUserGlobalRequestException(GlobalApiRequestException exception) {
        GlobalApiError userGlobalException = new GlobalApiError(
            exception.getMessage(),
            null
        );

        return new ResponseEntity<>(userGlobalException, exception.getHttpStatus());
    }
}
