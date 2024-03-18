package com.bankproject.bank.mapper.services;

import com.bankproject.bank.dto.response.services.LoanResponse;
import com.bankproject.bank.dto.services.LoanDTO;
import com.bankproject.bank.entity.services.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoanMapper {

    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);


    Loan toEntity(LoanDTO loanDTO);

    LoanDTO toDTO(Loan loan);

    LoanResponse toResponse(LoanDTO loanDTO);

}
