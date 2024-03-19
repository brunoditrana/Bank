package com.bankproject.bank.mapper;

import com.bankproject.bank.dto.services.ServicesDTO;
import com.bankproject.bank.entity.Services;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServicesMapper {


    ServicesMapper INSTANCE = Mappers.getMapper(ServicesMapper.class);


    Services toEntity(ServicesDTO dto );

    ServicesDTO toDTO( Services services);
}
