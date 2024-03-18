package com.bankproject.bank.mapper.services;

import com.bankproject.bank.dto.response.services.DepositsResponse;
import com.bankproject.bank.dto.services.DepositsDTO;
import com.bankproject.bank.entity.services.Deposits;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepositsMapper {


    DepositsMapper INSTANCE = Mappers.getMapper(DepositsMapper.class);

    Deposits toEntity(DepositsDTO dto);

    DepositsDTO toDTO(Deposits deposits);

    DepositsResponse toResponse(DepositsDTO dto);
}
