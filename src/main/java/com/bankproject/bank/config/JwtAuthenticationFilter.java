package com.bankproject.bank.config;

import com.bankproject.bank.adapter.ProfileAdapter;
import com.bankproject.bank.dto.ProfileUserDetailsService;
import com.bankproject.bank.mapper.ProfileMapper;
import com.bankproject.bank.service.IProfileService;
import com.bankproject.bank.service.ProfileService;
import com.bankproject.bank.service.auth.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ProfileAdapter profileAdapter;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //1- Obtener encabezado llamado Header:
        String authorizationHeader = request.getHeader("Authorization");

        if (!StringUtils.hasText(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        //2- Obtener el JWT del header
        String jwt = authorizationHeader.split(" ")[1];

        //3- Obtener el subjet/username desde el token
        //esta acciona su vez valida el formato, la firma y fecha de expiracion

        String username = jwtService.extractUsername(jwt);

        // 4- Setear objeto autthetication dentro del security conrtext holder
        ProfileUserDetailsService userDetails = profileAdapter.findByUsername(username);

        UsernamePasswordAuthenticationToken autheToken = new UsernamePasswordAuthenticationToken(
                username, null, userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(autheToken);

        //5- Ejecutar el registro de filtros
        filterChain.doFilter(request, response);
    }
}
