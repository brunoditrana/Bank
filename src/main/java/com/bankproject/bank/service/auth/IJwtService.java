package com.bankproject.bank.service.auth;

import com.bankproject.bank.dto.ProfileDTO;

import java.util.Map;

public interface IJwtService {

    String generateToken(ProfileDTO profileDTO, Map<String, Object> mpa);
}
