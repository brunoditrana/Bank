package com.bankproject.bank.dto.request;

import com.bankproject.bank.entity.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileUpdateRequest {


    private Long idProfile;

    private String username;

    private String password;

    private String name;

    private String lastName;

    private Role role;


}
