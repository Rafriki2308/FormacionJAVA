package com.bosonit.Ej15Security.role.infrastructure.controller.Output;


import com.bosonit.Ej15Security.role.domain.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleOutputDto {


    private Integer idRole;
    private String roleName;


    public RoleOutputDto(Role role) {
        setIdRole(role.getIdRole());
        setRoleName(role.getName());
    }
}

