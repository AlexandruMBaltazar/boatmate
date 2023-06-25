package com.amb.identityservice.account.dto;

public record AccountResponse(
    Long id,
    String name,
    String email
) {
}
