package com.bosonit.Ej15Security.security.userDetail;

import com.bosonit.Ej15Security.person.domain.Person;
import com.bosonit.Ej15Security.role.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
//Esta clase recibe un usuario
public class UserDetailImpl implements UserDetails {

    private Person person;

    //retorna los roles
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return mapRolesToAuthorities(person.getRoles());
    }
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return person.getPassword();
    }

    @Override
    public String getUsername() {
        return person.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNane(){
        return person.getName();
    }
}
