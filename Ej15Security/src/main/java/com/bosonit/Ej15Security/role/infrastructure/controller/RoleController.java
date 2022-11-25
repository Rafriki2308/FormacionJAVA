package com.bosonit.Ej15Security.role.infrastructure.controller;


import com.bosonit.Ej15Security.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej15Security.role.application.RoleServiceImp;
import com.bosonit.Ej15Security.role.infrastructure.controller.Input.RoleInputDto;
import com.bosonit.Ej15Security.role.infrastructure.controller.Output.RoleOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleServiceImp roleServiceImp;

    @PostMapping("")
    public Object addRole(@RequestBody RoleInputDto roleInputDto) {
        try {
            return roleServiceImp.addRole(roleInputDto);
        } catch (
                DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Role already existed");
        }
    }

    @GetMapping("/all")
    public List<RoleOutputDto> getAllRoles() {
        return roleServiceImp.getAllRoles();
    }

    @DeleteMapping("{idRole}")
    public ResponseEntity deleteRoleById(@PathVariable String id) {
        roleServiceImp.deleteRole(id);
        return ResponseEntity.ok().body("Role deleted");
    }

}
