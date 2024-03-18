package com.bankproject.bank.mapper;

import com.bankproject.bank.dto.AccountDTO;
import com.bankproject.bank.dto.response.AccountResponse;
import com.bankproject.bank.entity.Account;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);


    AccountDTO toDTO(Account account);

    AccountResponse toResponse(AccountDTO accountDTO);
}
