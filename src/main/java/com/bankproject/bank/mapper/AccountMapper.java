package com.bankproject.bank.mapper;

import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.dto.request.AccountRequest;
import com.bankproject.bank.dto.response.AccountResponse;
import com.bankproject.bank.entity.Account;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);


    Account toEntity(AccountDTO accountDTO);
    AccountDTO toDTO(Account account);

    AccountDTO toDTO(AccountRequest account);

    AccountResponse toResponse(AccountDTO accountDTO);
}
