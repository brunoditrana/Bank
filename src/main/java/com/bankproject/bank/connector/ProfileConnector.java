package com.bankproject.bank.connector;

import com.bankproject.bank.adapter.ProfileAdapter;
import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.entity.Profile;
import com.bankproject.bank.mapper.ProfileMapper;
import com.bankproject.bank.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileConnector implements ProfileAdapter {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ProfileUserDetailsService findByUsernameDetails(String username) {
        Profile profile = profileRepository.findByUsername(username).orElseThrow();

        ////// PONER EXCEPTIONS
        return ProfileMapper.INSTANCE.toProfileUserDetails(profile);

    }

    @Override
    public ProfileDTO findByUsername(String username) {

        //Exepctions
        Profile p = profileRepository.findByUsername(username).orElseThrow();

        return ProfileMapper.INSTANCE.toDTO(p);
    }

    @Override
    public ProfileDTO save(ProfileDTO profileDTO) {

        Profile profile = profileRepository.save(ProfileMapper.INSTANCE.toEntity(profileDTO));
        //Validaciones 26 11:50
        return ProfileMapper.INSTANCE.toDTO(profile);
    }

    @Override
    public void deleteProfile(String username) {

        profileRepository.deleteByUsername(username);

    }
}
