package com.bankproject.bank.mapper;

import com.bankproject.bank.dto.AccountServiceDTO;
import com.bankproject.bank.entity.AccountService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountServiceMapper {

    AccountServiceMapper INSTANCE = Mappers.getMapper(AccountServiceMapper.class);

    AccountService toEntity(AccountServiceDTO dto);
}
