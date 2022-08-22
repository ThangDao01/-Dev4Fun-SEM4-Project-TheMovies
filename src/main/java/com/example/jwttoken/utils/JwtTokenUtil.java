package com.example.jwttoken.utils;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtTokenUtil {

    private final String JWT_SECRET = "2639173692793719";
    private final long JWT_EXPIRATION = 604800000L;


    public String generateToken(User userDetail){
        Date data = new Date();
        Date expiryDate = new Date(data.getTime() + JWT_EXPIRATION);
         return Jwts.builder()
                 .setSubject(userDetail.getUsername())
                 .setIssuedAt(data)
                 .setExpiration(expiryDate)
                 .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                 .compact();
    }

    public String getUserNameFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken){
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex){
            System.out.println("token Invalid");
        }catch (ExpiredJwtException ex){
            System.out.println("Token Expired");
        }catch (UnsupportedJwtException ex){
            System.out.println("Unsupported token");
        }catch (IllegalArgumentException ex){
            System.out.println("JWT claims string is empty");
        }
        return false;
    }
}
