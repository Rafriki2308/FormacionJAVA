package com.bosonit.Ej15Security.role.infrastructure.controller;


import com.bosonit.Ej15Security.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej15Security.role.application.RoleServiceImp;
import com.bosonit.Ej15Security.role.domain.Role;
import com.bosonit.Ej15Security.role.infrastructure.controller.Input.RoleInputDto;
import com.bosonit.Ej15Security.role.infrastructure.controller.Output.RoleOutputDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@Slf4j
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

    @GetMapping("getRoleById/{id}")
    public RoleOutputDto getRoleById(@PathVariable String id) {
        return roleServiceImp.getRoleById(id);
    }

    @PutMapping("/{id}")
    public RoleOutputDto updateRoleById(@PathVariable String id, @RequestBody RoleInputDto roleInptuDto){
        return roleServiceImp.updateRoleById(roleInptuDto, id);
    }


    @DeleteMapping("{id}")
    public ResponseEntity deleteRoleById(@PathVariable String id) {

        try {
            roleServiceImp.deleteRole(id);
            return ResponseEntity.ok().body("Role deleted");
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.badRequest().body("Role doesn't exists");
        }
    }

}
