package com.bosonit.Ej15Security.security;


import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;

public class TokenUtils {
    private final static String ACCESS_TOKEN_SECRET="0758da1fe9134f30a587181db8b1e4eb";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS=2_592_000L; //Tiempo validez del token


    //Este metodo crea un token en funcion de las opciones que deseemos
    public static String createToken(String name, String username){

        //Este bloque define el tiempo de expiracion del token
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate= new Date(System.currentTimeMillis() + expirationTime);

        //Este bloque añade un extra de informacion al token
        Map<String, Object> extra = new HashMap<>();
        extra.put("name",name);

        Algorithm algorithm = Algorithm.HMAC256(ACCESS_TOKEN_SECRET.getBytes()); //Create hash algorithm

        return Jwts.builder()
                .setSubject(username) //Introducimos usuario
                .setExpiration(expirationDate)//Tiempo que expira el token
                .addClaims(extra)//Añade informacion adicional
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    //Esta clase se encarga de comprobar si casa el nombre del usuario con la contraseña
    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims = Jwts.parserBuilder()//Se encarga de deshacer el token
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())//Toma el token secreto
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String username = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(username, null, Collections.EMPTY_LIST);

        }catch (JwtException e){
         return null;
        }

    }
}
