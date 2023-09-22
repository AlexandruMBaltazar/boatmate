package com.amb.identityservice.account.dto.request;

public record AuthenticationRequest(
    String email,
    String password
) {
}
