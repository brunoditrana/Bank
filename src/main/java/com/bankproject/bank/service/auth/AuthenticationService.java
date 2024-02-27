package com.bankproject.bank.service.auth;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.dto.request.ProfileRequest;
import com.bankproject.bank.dto.response.ProfileResponse;
import com.bankproject.bank.mapper.ProfileMapper;
import com.bankproject.bank.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService implements IAuthenticationService, UserDetailsService {

    @Autowired
    private IProfileService profileService;



    @Autowired
    private IJwtService jwtService;
    @Override
    public ProfileUserDetailsService registerOneCustomer(ProfileRequest request) {

        ProfileDTO profileDTO = profileService.createProfile(ProfileMapper.INSTANCE.toDTO(request));

        ProfileUserDetailsService response = new ProfileUserDetailsService();
        response.setIdProfile(profileDTO.getIdProfile());
        response.setName(profileDTO.getName());
        response.setLastName(profileDTO.getLastName());
        response.setUsername(profileDTO.getUsername());
        response.setRole(profileDTO.getRole());

        String jwt = jwtService.generateToken(profileDTO, generateExtraClaims(profileDTO));
        response.setJwt(jwt);

        return null;
    }

    private Map<String, Object> generateExtraClaims(ProfileDTO profileDTO) {

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name",profileDTO.getName());
        extraClaims.put("role",profileDTO.getRole().name());
        extraClaims.put("authorities",profileDTO.getRole().getPermissions());

        return extraClaims;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
