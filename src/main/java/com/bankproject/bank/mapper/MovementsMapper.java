package com.bankproject.bank.mapper;

import com.bankproject.bank.dto.MovementsDTO;
import com.bankproject.bank.dto.response.MovementsResponse;
import com.bankproject.bank.entity.Movements;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovementsMapper {

    MovementsMapper INSTANCE = Mappers.getMapper(MovementsMapper.class);


    MovementsDTO toDTO(Movements movements);

    MovementsResponse toResponse(MovementsDTO movementsDTO);
}
