package com.bankproject.bank.dto.response;

import com.bankproject.bank.entity.Enum.Role;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse {

    private Long idProfile;

    private String username;

    private String name;

    private String lastName;

    private String email;

    private String role;

    private String jwt;
}
