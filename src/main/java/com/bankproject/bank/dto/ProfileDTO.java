package com.bankproject.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {

    private Long idProfile;

    private String username;

    private String name;

    private String lastName;

    private String email;

    private String role;


}
