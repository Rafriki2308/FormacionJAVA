package com.bosonit.Ej7.crud.Controller;

import com.bosonit.Ej7.crud.Services.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/URL")
public class DeletePerson {

    @Autowired
    private ManagerRepository managerRepository;

    @DeleteMapping("persona/{id}")
    public Boolean deletePerson(@PathVariable String id){
        return managerRepository.deletePersonById(id);
    }
}
