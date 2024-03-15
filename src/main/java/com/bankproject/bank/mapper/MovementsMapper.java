package com.bankproject.bank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovementsMapper {

    MovementsMapper INSTANCE = Mappers.getMapper(MovementsMapper.class);

}
