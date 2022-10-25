package com.bosonit.Ej13.crudvalidation.person.infraestructure.controller.output;

import com.bosonit.Ej13.crudvalidation.person.domain.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonResponseDto {

    public List<PersonOutputFatherDto> mappingPersonToPersonDtoOutputSimple(List<Person> listPerson){

        List<PersonOutputFatherDto> listPersonDtoOutput = new ArrayList<>();
        for (Person p: listPerson) {
            listPersonDtoOutput.add(new PersonOutputDto(p));
        }
        return listPersonDtoOutput;
    }

    public List<PersonOutputFatherDto> mappingPersonToPersonDtoOutputFull(List<Person> listPerson){

        List<PersonOutputFatherDto> listPersonDtoOutput = new ArrayList<>();
        for (Person p: listPerson) {
                if(p.getProfessor()==null && p.getStudent()==null) {
                    listPersonDtoOutput.add(new PersonOutputDto(p));
                }else if (p.getStudent()==null){
                    listPersonDtoOutput.add(new PersonOutputProfessorDto(p));
                }else{
                    listPersonDtoOutput.add(new PersonOutputStudentDto(p));
                }
        }
        return listPersonDtoOutput;
    }

}
