package com.bosonit.Ej7.crudvalidation.PersonDto;

import com.bosonit.Ej7.crudvalidation.Model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDtoResponse {

    private static List<PersonDto> listPersonDto = new ArrayList<>();

    public List<PersonDto> getListPersonDto(){
        return listPersonDto;
    }

    public void setListPersonDto(List<PersonDto> listPersonDto){
        this.listPersonDto = listPersonDto;
    }

    public void addListPersonDto(PersonDto personDto){
        this.listPersonDto.add(personDto);
    }


}
