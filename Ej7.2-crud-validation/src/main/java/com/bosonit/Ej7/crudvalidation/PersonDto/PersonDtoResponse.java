package com.bosonit.Ej7.crudvalidation.PersonDto;

import com.bosonit.Ej7.crudvalidation.Model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDtoResponse {

    private static List<PersonDtoOutput> listPersonDtoOutput = new ArrayList<>();

    public List<PersonDtoOutput> mappingPersonToPersonDtoOutput(List<Person> listPerson){
        for (Person p: listPerson) {
            listPersonDtoOutput.add(new PersonDtoOutput(p));
        }
        return listPersonDtoOutput;
    }

}
