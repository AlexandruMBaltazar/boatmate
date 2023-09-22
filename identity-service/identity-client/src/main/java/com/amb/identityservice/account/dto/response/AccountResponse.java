package com.amb.identityservice.account.dto.response;

import com.amb.identityservice.account.model.Account.Role;


public record AccountResponse(
    Long id,
    String name,
    String email,
    Role role
) {
}
