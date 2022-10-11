package com.bosonit.Ej10.Dockerizacionaplicacion.validator;

import com.bosonit.Ej10.Dockerizacionaplicacion.exceptions.UnprocessableEntityException;
import com.bosonit.Ej10.Dockerizacionaplicacion.person.infraestructure.controller.input.PersonInputDto;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Validator {

    private Boolean checkNullField(String field) throws UnprocessableEntityException {
        if(field.isEmpty()){
            throw new UnprocessableEntityException("El Campo esta vacio");
        }
        return true;
    }

    private Boolean checkNullFieldDate(Date field) throws UnprocessableEntityException {
        if(field == null){
            throw new UnprocessableEntityException("El Campo esta vacio");
        }
        return true;
    }

    private Boolean checkNullFieldActive(Boolean field) throws UnprocessableEntityException {
        if(field == null){
            throw new UnprocessableEntityException("El Campo esta vacio");
        }
        return true;
    }

    private Boolean checkLength(String field) throws Exception {
        if(field.length()>5 && field.length()<11){
            return true;
        }
        throw new UnprocessableEntityException("El es menor de 6 caracteres o mayor de 11 caracteres");
    }

    public Boolean checkPersonDtoImput(PersonInputDto personDtoInput) {
        Boolean userIsValid = null;
        try {
            userIsValid = checkLength(personDtoInput.getUser()) && checkNullField(personDtoInput.getUser());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Boolean passwordIsValid = checkNullField(personDtoInput.getPassword());
        Boolean nameIsValid = checkNullField(personDtoInput.getName());
        Boolean companyEmailIsValid = checkNullField(personDtoInput.getCompany_email());
        Boolean personalEmailIsValid = checkNullField(personDtoInput.getPersonal_email());
        Boolean cityIsValid = checkNullField(personDtoInput.getCity());
        Boolean activeIsValid = checkNullFieldActive(personDtoInput.getActive());
        Boolean createDate = checkNullFieldDate(personDtoInput.getCreated_date());

        return userIsValid && passwordIsValid && nameIsValid && companyEmailIsValid && personalEmailIsValid &&
                cityIsValid && activeIsValid && createDate;

    }


}
