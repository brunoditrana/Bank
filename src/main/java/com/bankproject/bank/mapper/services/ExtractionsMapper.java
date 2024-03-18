package com.bankproject.bank.mapper.services;

import com.bankproject.bank.dto.response.services.DepositsResponse;
import com.bankproject.bank.dto.response.services.ExtractionsResponse;
import com.bankproject.bank.dto.services.DepositsDTO;
import com.bankproject.bank.dto.services.ExtractionsDTO;
import com.bankproject.bank.entity.services.Deposits;
import com.bankproject.bank.entity.services.Extractions;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExtractionsMapper {


    ExtractionsMapper INSTANCE = Mappers.getMapper(ExtractionsMapper.class);

    Extractions toEntity(ExtractionsDTO dto);

    ExtractionsDTO toDTO(Extractions entity);

    ExtractionsResponse toResponse(ExtractionsDTO dto);
}
