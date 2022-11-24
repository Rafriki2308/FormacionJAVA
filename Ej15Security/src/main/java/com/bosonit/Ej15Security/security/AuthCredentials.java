package com.bosonit.Ej15Security.security;

import com.bosonit.Ej15Security.role.domain.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
//Esta clase se va a encargar de comprobar la utenticacion de un usuario
public class AuthCredentials {

    private String username;
    private String password;
    private List<Role> roles = new ArrayList<>();

}
