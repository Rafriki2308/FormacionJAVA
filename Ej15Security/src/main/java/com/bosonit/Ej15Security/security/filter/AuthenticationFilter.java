package com.bosonit.Ej15Security.security.filter;

import com.bosonit.Ej15Security.security.credential.AuthCredentials;
import com.bosonit.Ej15Security.security.token.TokenUtils;
import com.bosonit.Ej15Security.security.userDetail.UserDetailImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Este es un filto para la autenticacion, comprueba si tus credenciales son correctas o no
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    //Este metodo recibe y devuelve la peticion y la respuesta, en caso que la utenticacion sea correcta o
    //en caso contrario envia una excepcion
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        AuthCredentials authCredentials;

        //Este bloque comprueba las credenciales que ha tomado de la request
        //En caso de fallo devuelve una excepcion.
        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                authCredentials.getUsername(),
                authCredentials.getPassword(),
                authCredentials.getRoles()
        );
        return getAuthenticationManager().authenticate(usernamePAT);
    }

    //Esta clase se encarga de devolver el token atraves del Header
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {


        //Capturamos un usuario y lo guardamos en la clase UserDetailImpl
        UserDetailImpl userDetail = (UserDetailImpl) authResult.getPrincipal();
        //Realizamos un token con los datos de dicho usuario
        String token = TokenUtils.createToken(
                userDetail.getUsername(),
                userDetail.getNane(),
                authResult);

        //Modificamos la respuesta para poder agregar el token
        //Pondremos el nombre del encabezado y el Standar Bearer y el token
        response.addHeader("Authorization", "Bearer " + token);
        //Hacemos que los cambios sean permanentes
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }
}
