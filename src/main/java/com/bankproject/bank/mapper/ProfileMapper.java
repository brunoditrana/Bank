package com.bankproject.bank.mapper;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.dto.request.ProfileRequest;
import com.bankproject.bank.dto.response.ProfileResponse;
import com.bankproject.bank.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;

@Mapper
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    ProfileUserDetailsService toProfileUserDetails(Profile profile);

    Profile toEntity(ProfileDTO profileDTO);
    ProfileDTO toDTO(Profile profile);

    ProfileDTO toDTO(ProfileRequest profileRequest);

    ProfileResponse toResponse(ProfileDTO profileDTO);


    ProfileResponse toResponse(ProfileUserDetailsService prf);

}
