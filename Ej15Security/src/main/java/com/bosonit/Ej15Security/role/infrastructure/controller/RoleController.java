package com.bosonit.Ej15Security.role.infrastructure.controller;


import com.bosonit.Ej15Security.role.application.RoleServiceImp;
import com.bosonit.Ej15Security.role.infrastructure.controller.Input.RoleInputDto;
import com.bosonit.Ej15Security.role.infrastructure.controller.Output.RoleOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleServiceImp roleServiceImp;

    @PostMapping("")
    public RoleOutputDto addRole(@RequestBody RoleInputDto roleInputDto){

        return roleServiceImp.addRole(roleInputDto);
    }

    /*@PostMapping(value = "/addroletouser")
    public PersonOutputDto addRoleToUser(@RequestParam String username, @RequestParam String roleName) {
        return roleServiceImp.addRoleToPerson(username,roleName);
    }*/

    @GetMapping("/all")
    public List<RoleOutputDto> getAllRoles(){
        return roleServiceImp.getAllRoles();
    }

    @DeleteMapping("")
    public ResponseEntity deleteRoleById(@PathVariable String id){
        roleServiceImp.deleteRole(id);
        return ResponseEntity.ok().body("Role deleted");
    }

}
