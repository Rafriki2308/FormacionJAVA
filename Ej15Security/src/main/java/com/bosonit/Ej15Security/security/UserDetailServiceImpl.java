package com.bosonit.Ej15Security.security;

import com.bosonit.Ej15Security.person.domain.Person;
import com.bosonit.Ej15Security.person.infraestructure.repository.PersonRepository;
import com.bosonit.Ej15Security.role.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//Esta clase se va a encargar de buscar el usuario a identificar en la BD
//Y devuelve dicha persona como un UserDetailImpl
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person person = personRepository.findByUsername(username);
        if(person.equals(null)){
            throw new UsernameNotFoundException("El usuario" + username + "no existe");
        }

        return new UserDetailImpl(person.getUsername(),person.getPassword(),person.getRoles());
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName().collect(Collectors.toList())));
    }


}
