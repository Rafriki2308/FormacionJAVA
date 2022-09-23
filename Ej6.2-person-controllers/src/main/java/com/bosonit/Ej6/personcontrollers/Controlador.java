package com.bosonit.Ej6.personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/controlador")
public class Controlador {

    @Autowired
    @Qualifier("bean1")
    private Person person1;

    @Autowired
    @Qualifier("bean2")
    private Person person2;

    @Autowired
    @Qualifier("bean3")
    private Person person3;

    @GetMapping("/bean/{bean}")
    public Person getPersonaByBean(@PathVariable String bean){

        if(bean.equals("bean1")){
            return this.person1;
        }
        if(bean.equals("bean2")){
            return this.person2;
        }
        if(bean.equals("bean3")){
            return this.person3;
        }
        return null;
    }
}
