package com.bosonit.Ej15Security.security.credential;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;


@Data
//Esta clase se va a encargar de comprobar la utenticacion de un usuario
public class AuthCredentials {

    private String username;
    private String password;
    private Collection<GrantedAuthority> roles = new ArrayList<>();

}
