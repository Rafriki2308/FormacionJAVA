package com.bosonit.Ej15Security.security.filter;

import com.bosonit.Ej15Security.security.token.TokenUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Esta clase se va a encargar, una vez autenticados en decidir donde puede y no puede acceder
//el usuario utilizando el filterChain que hemos declarado en la clase setup
@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        //Aqui recogemos el token que envia el usuario
        String bearerToken = request.getHeader("Authorization");

        //Comprobamos la integridad del token
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            //Vamos a extraer el toker del bearer
            String token = bearerToken.replace("Bearer ", "");
            //Comprobamos que el token sea correcto
            UsernamePasswordAuthenticationToken usenamePAT = TokenUtils.getAuthentication(token);
            //Establecemos la autenticacion
            SecurityContextHolder.getContext().setAuthentication(usenamePAT);
        }

        filterChain.doFilter(request, response);
    }
}
