package com.bosonit.Ej15Security.role.infrastructure.controller.Output;



import com.bosonit.Ej15Security.role.domain.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleResponseDto {

    public List<RoleOutputDto> mappingRoleToRoleDtoOutput(List<Role> roles){

        List<RoleOutputDto> rolesDtoOutput = new ArrayList<>();
        for (Role r: roles) {
            rolesDtoOutput.add(new RoleOutputDto(r));
        }
        return rolesDtoOutput;
    }
}
