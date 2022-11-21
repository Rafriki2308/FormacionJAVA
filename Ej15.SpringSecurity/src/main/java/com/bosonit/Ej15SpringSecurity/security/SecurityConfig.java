package com.bosonit.Ej15SpringSecurity.security;

import com.bosonit.Ej15SpringSecurity.security.filter.CustomAuthenticationFilter;
import com.bosonit.Ej15SpringSecurity.security.filter.CustomAuthorizationFilter;
import org.codehaus.plexus.component.annotations.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean(authenticationConfiguration));
        customAuthenticationFilter.setFilterProcessesUrl("/login");
        http.csrf().disable()
                .authorizeRequests().antMatchers(POST,"/login").hasAnyAuthority("true")
                .antMatchers(GET,"/ejemplo1/**").hasAnyAuthority("ADMIN")
                .antMatchers(GET,"/ejemplo2/**").hasAnyAuthority("EMPLOYEE")
                .anyRequest().authenticated()
                .and()
                .addFilter(customAuthenticationFilter)
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
