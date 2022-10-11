package com.bosonit.Ej10.Dockerizacionaplicacion.person.infraestructure.controller.input.output;

import com.bosonit.Ej10.Dockerizacionaplicacion.person.domain.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonResponseDto {

    public List<PersonOutputDto> mappingPersonToPersonDtoOutput(List<Person> listPerson){

        List<PersonOutputDto> listPersonDtoOutput = new ArrayList<>();
        for (Person p: listPerson) {
            listPersonDtoOutput.add(new PersonOutputDto(p));
        }
        return listPersonDtoOutput;
    }
}
