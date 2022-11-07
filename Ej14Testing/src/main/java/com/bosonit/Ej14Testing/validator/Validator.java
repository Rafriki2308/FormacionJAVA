package com.bosonit.Ej14Testing.validator;


import com.bosonit.Ej14Testing.exceptions.UnprocessableEntityException;
import com.bosonit.Ej14Testing.person.infraestructure.controller.input.PersonInputDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@NoArgsConstructor
public class Validator {

    protected Boolean checkNullField(String field) throws UnprocessableEntityException {
        if(field.isEmpty()){
            throw new UnprocessableEntityException("El Campo esta vacio");
        }
        return true;
    }

    protected Boolean checkNullFieldDate(Date field) throws UnprocessableEntityException {
        if(field == null){
            throw new UnprocessableEntityException("El Campo esta vacio");
        }
        return true;
    }

    protected Boolean checkNullFieldActive(Boolean field) throws UnprocessableEntityException {
        if(field == null){
            throw new UnprocessableEntityException("El Campo esta vacio");
        }
        return true;
    }

    protected Boolean checkLength(String field) throws Exception {
        if(field.length()>5 && field.length()<11){
            return true;
        }
        throw new UnprocessableEntityException("El campo user es menor de 6 caracteres o mayor de 11 caracteres");
    }

    public Boolean checkPersonDtoImput(PersonInputDto personDtoInput) {
        Boolean userIsValid = null;
        try {
            userIsValid = checkLength(personDtoInput.getUser()) && checkNullField(personDtoInput.getUser());
        } catch (Exception e) {
            throw new UnprocessableEntityException("El campo user es menor de 6 caracteres o mayor de 11 caracteres");
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
