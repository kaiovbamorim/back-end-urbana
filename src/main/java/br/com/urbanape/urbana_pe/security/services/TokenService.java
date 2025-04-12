package br.com.urbanape.urbana_pe.security.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class TokenService {
    
    @Value("{security.token.secret}")
    private String secretHash;

    public DecodedJWT validateToken(String token){
        token = token.replace("Bearer ", "");

        Algorithm hash = Algorithm.HMAC256(secretHash);

        try {
            var tokenDecoded = JWT.require(hash)
            .build()
            .verify(token);
            return tokenDecoded;
        } catch (JWTVerificationException e){
            e.printStackTrace();
            return null;
        }
    }

}
