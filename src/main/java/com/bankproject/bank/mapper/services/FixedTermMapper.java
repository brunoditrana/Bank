package com.bankproject.bank.mapper.services;

import com.bankproject.bank.dto.response.services.ExtractionsResponse;
import com.bankproject.bank.dto.response.services.FixedTermResponse;
import com.bankproject.bank.dto.services.ExtractionsDTO;
import com.bankproject.bank.dto.services.FixedTermDTO;
import com.bankproject.bank.entity.services.Extractions;
import com.bankproject.bank.entity.services.FixedTerm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FixedTermMapper {


    FixedTermMapper INSTANCE = Mappers.getMapper(FixedTermMapper.class);

    FixedTerm toEntity(FixedTermDTO dto);

    FixedTermDTO toDTO(FixedTerm entity);

    FixedTermResponse toResponse(FixedTermDTO dto);
}
