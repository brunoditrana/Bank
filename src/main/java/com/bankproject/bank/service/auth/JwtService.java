package com.bankproject.bank.service.auth;

import com.bankproject.bank.dto.ProfileDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
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
        Date expiration = new Date( (EXPIRATION_IN_MINUTES * 60 * 1000) + issued.getTime());

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

    @Override
    public String extractUsername(String jwt) {

        return extractAllClaims(jwt).getSubject();
    }

    private Claims extractAllClaims(String jwt) {

     return Jwts.parser().verifyWith( generateKey()).build()
                .parseSignedClaims(jwt).getPayload();
    }

    private SecretKey generateKey() {

        byte[] passwordDecoded = Decoders.BASE64.decode(SECRET_KEY);

        return Keys.hmacShaKeyFor(passwordDecoded);

    }


}
