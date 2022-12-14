package com.bosonit.Ej15Security.role.domain;


import com.bosonit.Ej15Security.role.infrastructure.controller.Input.RoleInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "RoleTable")
    @Column
    private Integer idRole;

    @Column(unique = true)
    private String name;

    public Role (RoleInputDto roleInputDto){
       setName(roleInputDto.getRoleName());
    }

    public Role (RoleInputDto roleInputDto, Integer id){
        setName(roleInputDto.getRoleName());
        setIdRole(id);
    }

}
