package com.bosonit.Ej15Security.role.application;

import com.bosonit.Ej15Security.exceptions.EntityNotFoundException;
import com.bosonit.Ej15Security.person.domain.Person;
import com.bosonit.Ej15Security.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej15Security.person.infraestructure.repository.PersonRepository;

import com.bosonit.Ej15Security.role.domain.Role;
import com.bosonit.Ej15Security.role.infrastructure.controller.Input.RoleInputDto;
import com.bosonit.Ej15Security.role.infrastructure.controller.Output.RoleOutputDto;
import com.bosonit.Ej15Security.role.infrastructure.controller.Output.RoleResponseDto;
import com.bosonit.Ej15Security.role.infrastructure.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleServiceImp implements RoleService{

    @Autowired
    private RoleRepository rR;

    @Autowired
    private PersonRepository pR;

    @Autowired
    private RoleResponseDto roleResponseDto;

    @Override
    public RoleOutputDto addRole(RoleInputDto roleInputDto){
        return new RoleOutputDto(rR.save(new Role(roleInputDto)));
    }

    @Override
    public PersonOutputDto addRoleToPerson(String username, String roleName) {

        Person person = pR.findByUser(username);
        if(person.equals(null)){
            throw new EntityNotFoundException("The person doesn't exist");
        }

        Role role = rR.findByName(roleName);
        if(role.equals(null)){
            throw new EntityNotFoundException("The role doesn't exist");
        }
        person.getRoles().add(role);
        return new PersonOutputDto(pR.save(person));

    }

    @Override
    public List<RoleOutputDto> getAllRoles() {
        return roleResponseDto.mappingRoleToRoleDtoOutput(rR.findAll());
    }

    @Override
    public void deleteRole(String idRole) {
        rR.deleteById(Integer.parseInt(idRole));
    }
}
