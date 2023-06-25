package com.amb.identityservice.mapper;

import com.amb.identityservice.account.dto.AccountRequest;
import com.amb.identityservice.account.dto.AccountResponse;
import com.amb.identityservice.account.model.Account;
import com.amb.identityservice.account.model.Account.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(Account.Role" +
        ".valueOf(accountRequest.role().toUpperCase()))")
    Account accountRequestToAccount(AccountRequest accountRequest);

    AccountResponse accountToAccountResponse(Account account);
}
