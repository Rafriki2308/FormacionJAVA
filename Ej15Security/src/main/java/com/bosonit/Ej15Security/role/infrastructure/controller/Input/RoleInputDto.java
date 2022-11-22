package com.bosonit.Ej15Security.role.infrastructure.controller.Input;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleInputDto {


    private String roleName;

    public RoleInputDto(String roleName) {
        setRoleName(roleName);
    }
}

