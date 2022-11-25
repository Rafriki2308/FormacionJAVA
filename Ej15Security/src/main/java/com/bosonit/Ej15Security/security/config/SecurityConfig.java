package com.bosonit.Ej15Security.security.config;

import com.bosonit.Ej15Security.person.application.PersonServiceImpl;
import com.bosonit.Ej15Security.security.filter.AuthorizationFilter;
//import com.bosonit.Ej15Security.security.userDetail.UserDetailServiceImpl;
import com.bosonit.Ej15Security.security.filter.AuthenticationFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@Configuration
@AllArgsConstructor
@Slf4j
public class SecurityConfig {

    private final PersonServiceImpl personService;

    //Este filtro se puede instanciar sin necesidad de parametros
    private final AuthorizationFilter authorizationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {

        //Como esta clase la hemos creado nosotros y no es gestionada por el core de security la instanciamos
        //y la configuramos nosotros
        AuthenticationFilter authenticationFilter = new AuthenticationFilter();

        //Le asignamos el authenticationManager necesario
        authenticationFilter.setAuthenticationManager(this.authManager(http));

        //Le indicamos el endpoint de inicio de sesion
        authenticationFilter.setFilterProcessesUrl("/login");


        return http
                .csrf().disable() //Deshabilita crosfire request forged, para evitar peticiones maliciosas
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST)//Indica que paginas o metodos estan restrigidos
                .hasAnyAuthority("ROLE_ADMIN")//Indica quien tiene persmiso a accedera a los recursos indicados arriba
                .antMatchers(HttpMethod.PUT)
                .hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE)
                .hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/role/**")
                .hasAnyAuthority("ROLE_ADMIN")
                .anyRequest() //Para cualquier request
                .authenticated() //Autentica
                .and()//y
                //.httpBasic()//Seguridad Basica de usuario y contraseña
                //.and()//y
                .sessionManagement()//gestion de sesiones
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//Politica de sesiones
                .and()
                .addFilter(authenticationFilter)//Añadimos el filtro de autenticacion
                //Este componente añade el filtro de autorizacion antes de la clase indicada
                .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();//Construye el filtro de seguridad
    }

    /*Esta comentado porque vamos a inyectar este metodo,
    lo hemos utilizado a modo de prueba al iniciar el proyecto.
    Este Metodo se encarga de generar un usuario inicial*/
    /*@Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("password"))
                .roles("ROLE_ADMIN")
                .build());
        return manager;
    }*/

    //Esta clase autentica la conexion
    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception {

        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(personService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    //Este metodo encripta el password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}


