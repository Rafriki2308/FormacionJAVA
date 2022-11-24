package com.bosonit.Ej15Security.security;


import com.auth0.jwt.algorithms.Algorithm;
import com.bosonit.Ej15Security.person.infraestructure.repository.PersonRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

public class TokenUtils {
    private final static String ACCESS_TOKEN_SECRET="0758da1fe9134f30a587181db8b1e4eb";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS=2_592_000L; //Tiempo validez del token
    private static final String AUTHORITIES_KEY = "authorities" ;

    @Autowired
    private PersonRepository personRepository;
    //Este metodo crea un token en funcion de las opciones que deseemos
    public static String createToken(String name, String username, Authentication authentication){

        //Este bloque define el tiempo de expiracion del token
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate= new Date(System.currentTimeMillis() + expirationTime);
        final String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        //Este bloque añade un extra de informacion al token
        Map<String, Object> extra = new HashMap<>();
        extra.put("name",name);

        Algorithm algorithm = Algorithm.HMAC256(ACCESS_TOKEN_SECRET.getBytes()); //Create hash algorithm

        return Jwts.builder()
                .setSubject(username) //Introducimos usuario
                .setExpiration(expirationDate)//Tiempo que expira el token
                .claim(AUTHORITIES_KEY, authorities)
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
            //Obtiene los roles y los guarda en un Collection de tipo SimpleGranted
            final Collection<SimpleGrantedAuthority> authorities =
                    Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());
            Collection<GrantedAuthority> roles = new ArrayList<>();

            return new UsernamePasswordAuthenticationToken(username, null, authorities);

        }catch (JwtException e){
         return null;
        }

    }
}
