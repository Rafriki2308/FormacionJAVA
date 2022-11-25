/*package com.bosonit.Ej15Security.security.controller;

import com.bosonit.Ej15Security.security.credential.AuthCredentials;
import com.bosonit.Ej15Security.security.filter.AuthenticationFilter;
import org.apache.maven.artifact.repository.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Profile("security")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationFilter authentication;

    @PostMapping
    public AuthCredentials login(@RequestParam String username, @RequestParam String password) {
        return new AuthCredentials(username,authentication.attemptAuthentication(username,password));
    }
}*/
