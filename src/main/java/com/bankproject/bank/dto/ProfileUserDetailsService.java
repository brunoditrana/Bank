package com.bankproject.bank.dto;

import com.bankproject.bank.entity.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileUserDetailsService implements UserDetails {

    private Long idProfile;

    private String username;

    private String password;

    private String name;

    private String lastName;

    private String email;

    private Role role;

    private String jwt;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (role == null || role.getPermissions() == null ) return null;

       List<SimpleGrantedAuthority> authorities = role.getPermissions().stream()
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

       authorities.add(new SimpleGrantedAuthority("ROLE_" + this.role.name()));
       return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getRoleName() {
        return role != null ? role.name() : null;
    }


}
