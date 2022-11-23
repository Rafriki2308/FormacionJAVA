package com.bosonit.Ej15Security.security;

import lombok.Data;


@Data
//Esta clase se va a encargar de comprobar la utenticacion de un usuario
public class AuthCredentials {

    private String username;
    private String password;

}
