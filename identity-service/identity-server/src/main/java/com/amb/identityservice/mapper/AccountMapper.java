package com.amb.identityservice.mapper;

import com.amb.identityservice.account.dto.request.AccountRequest;
import com.amb.identityservice.account.dto.response.AccountResponse;
import com.amb.identityservice.account.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = PasswordEncoderMapper.class)
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(Account.Role" +
        ".valueOf(accountRequest.role().toUpperCase()))")
    @Mapping(target = "password", qualifiedBy = EncodeMapping.class)
    Account accountRequestToAccount(AccountRequest accountRequest);

    AccountResponse accountToAccountResponse(Account account);
}
