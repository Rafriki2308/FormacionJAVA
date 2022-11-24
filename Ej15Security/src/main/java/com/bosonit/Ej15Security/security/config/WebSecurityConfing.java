package com.bosonit.Ej15Security.security.config;

import com.bosonit.Ej15Security.security.filter.JWTAuthenticationFilter;
import com.bosonit.Ej15Security.security.filter.JWTAuthorizationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.swing.text.html.FormSubmitEvent;

import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;

@Configuration
@AllArgsConstructor
public class WebSecurityConfing {

    private final UserDetailsService userDetailsService;

    //Este filtro se puede instanciar sin necesidad de parametros
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {

        //Como esta clase la hemos creado nosotros y no es gestionada por el core de security la instanciamos
        //y la configuramos nosotros
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();

        //Le asignamos el authenticationManager necesario
        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
        //Le indicamos el endpoint de inicio de sesion
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        return http
                .csrf().disable() //Deshabilita crosfire request forged, para evitar peticiones maliciosas
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST)
                .hasAnyRole("ROLE_ADMIN")
                .anyRequest() //Para cualquier request
                .authenticated() //Autentica
                //.and()//y
                //.httpBasic()//Seguridad Basica de usuario y contraseña
                .and()//y
                .sessionManagement()//gestion de sesiones
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//Politica de sesiones
                .and()
                .addFilter(jwtAuthenticationFilter)//Añadimos el filtro de autenticacion
                //Este componente añade el filtro de autorizacion antes de la clase indicada
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();//Construye el filtro de seguridad
    }

    /*Esta comentado porque vamos a inyectar este metodo,
    lo hemos utilizado a modo de prueba al iniciar el proyecto.
    Este Metodo se encarga de generar un usuario inicial
    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("password"))
                .roles()
                .build());
        return manager;
    }*/

    //Esta clase autentica la conexion
    @Bean
    AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    //Este metodo encripta el password
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
    }

}


