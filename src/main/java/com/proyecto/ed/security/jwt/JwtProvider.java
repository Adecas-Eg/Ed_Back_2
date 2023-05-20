package com.proyecto.ed.security.jwt;


import com.proyecto.ed.model.User;
import com.proyecto.ed.security.model.UsuarioPrincipal;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component

public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
//estas varibales estan en secret y expiration providir
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        UsuarioPrincipal userPrincipal = (UsuarioPrincipal) authentication.getPrincipal() ;

        return Jwts.builder().setSubject(userPrincipal.getUsername()).setExpiration(new Date
                (new Date().getTime()+ expiration*1000)).signWith(SignatureAlgorithm.HS512,secret).compact();
    }

    public String getEmailFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    public Boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("Token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error("Token no soportado");
        }catch (ExpiredJwtException e){
            logger.error("el token ya a expirado");
        }catch (IllegalArgumentException e){
            logger.error("Token Vcio");
        }catch (SignatureException e){
            logger.error("fallo en la firma");
        }
        return false;
    }
}
