package com.bosonit.Ej15Security.role.application;


import com.bosonit.Ej15Security.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej15Security.role.infrastructure.controller.Input.RoleInputDto;
import com.bosonit.Ej15Security.role.infrastructure.controller.Output.RoleOutputDto;

import java.util.List;

public interface RoleService {
    RoleOutputDto addRole(RoleInputDto roleInputDto);

    PersonOutputDto addRoleToPerson(String username, String roleName);

    List<RoleOutputDto> getAllRoles();

    void deleteRole(String idRole);
}
