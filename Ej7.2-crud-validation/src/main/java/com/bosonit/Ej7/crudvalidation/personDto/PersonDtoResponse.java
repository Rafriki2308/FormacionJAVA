package com.bosonit.Ej7.crudvalidation.personDto;

import com.bosonit.Ej7.crudvalidation.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDtoResponse {

    public List<PersonDtoOutput> mappingPersonToPersonDtoOutput(List<Person> listPerson){

        List<PersonDtoOutput> listPersonDtoOutput = new ArrayList<>();
        for (Person p: listPerson) {
            listPersonDtoOutput.add(new PersonDtoOutput(p));
        }
        return listPersonDtoOutput;
    }

}
