package com.bankproject.bank.mapper.services;

import com.bankproject.bank.dto.request.services.LoanRequest;
import com.bankproject.bank.dto.response.services.LoanResponse;
import com.bankproject.bank.dto.services.LoanDTO;
import com.bankproject.bank.entity.services.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LoanMapper {

    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);


    Loan toEntity(LoanDTO loanDTO);

    LoanDTO toDTO(Loan loan);

    LoanDTO toDTO(LoanRequest loanRequest);

    LoanResponse toResponse(LoanDTO loanDTO);

    List<LoanDTO> toList(List<Loan> l);

    List<LoanResponse> toListResponse( List<LoanDTO> l);

}
