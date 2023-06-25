package com.amb.identityservice.account.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonDeserialize(builder = Account.AccountBuilder.class)
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Getter
@Entity(name = "account")
public final class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private final Long id;

    @Column(nullable = false)
    private final String name;

    @Column(nullable = false, unique = true)
    private final String email;

    @Column(nullable = false)
    private final String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private final Role role;

    public enum Role {
        OWNER, CREW, SUPPLIER, CLIENT, ADMIN
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class AccountBuilder {
    }
}
