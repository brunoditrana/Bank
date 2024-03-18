package com.bankproject.bank.mapper;

import com.bankproject.bank.dto.BranchDTO;
import com.bankproject.bank.dto.response.BranchResponse;
import com.bankproject.bank.entity.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BranchMapper {

    BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class);


    Branch toEntity(BranchDTO branchDTO);

    BranchDTO toDTO(Branch branch);

    BranchResponse toResponse(BranchDTO branchDTO);
}
