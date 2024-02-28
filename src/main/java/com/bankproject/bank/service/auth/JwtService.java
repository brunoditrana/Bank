package com.bankproject.bank.service.auth;

import com.bankproject.bank.dto.ProfileDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService implements IJwtService{


    @Value("${security.jwt.expiration-in-minutes}")
    private Long EXPIRATION_IN_MINUTES;

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY ;

    @Override
    public String generateToken(ProfileDTO profileDTO, Map<String, Object> extraClaims) {

        Date issued = new Date(System.currentTimeMillis());
        Date expiration = new Date( (EXPIRATION_IN_MINUTES * 60 * 100) + issued.getTime());

        String jwt = Jwts.builder()

                .header()
                    .type("JWT")
                    .and()

                .subject(profileDTO.getUsername())
                .issuedAt(issued)
                .expiration(expiration)
                .claims(extraClaims)

                .signWith(generateKey(), Jwts.SIG.HS256)

                .compact();

        return jwt;
    }

    private SecretKey generateKey() {

        byte[] key = SECRET_KEY.getBytes();

        return Keys.hmacShaKeyFor(key);

    }


}
