package com.bosonit.Ej15Security.role.domain;


import com.bosonit.Ej15Security.role.infrastructure.controller.Input.RoleInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String name;

    public Role (RoleInputDto roleInputDto){
       setName(roleInputDto.getRoleName());
    }

}
