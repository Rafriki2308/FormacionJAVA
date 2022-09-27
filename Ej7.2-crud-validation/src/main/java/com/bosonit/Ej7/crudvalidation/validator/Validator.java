package com.bosonit.Ej7.crudvalidation.validator;

import com.bosonit.Ej7.crudvalidation.PersonDto.PersonDtoInput;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    private Boolean checkNullField(Object field) throws Exception {
        if(!(field == null)){
            return true;
        }
        throw new Exception("Un campo no es válido");
    }

    private Boolean checkLength(String field) throws Exception {
        if(field.length()>5 && field.length()<11){
            return true;
        }
        throw new Exception("Un campo no es válido");
    }

    public Boolean checkPersonDtoImput(PersonDtoInput personDtoInput) throws Exception {
        Boolean userIsValid = checkLength(personDtoInput.getUser()) && checkNullField(personDtoInput.getUser());
        Boolean passwordIsValid = checkNullField(personDtoInput.getPassword());
        Boolean nameIsValid = checkNullField(personDtoInput.getName());
        Boolean companyEmailIsValid = checkNullField(personDtoInput.getCompany_email());
        Boolean personalEmailIsValid = checkNullField(personDtoInput.getPersonal_email());
        Boolean cityIsValid = checkNullField(personDtoInput.getCity());
        Boolean activeIsValid = checkNullField(personDtoInput.getActive());
        Boolean createDate = checkNullField(personDtoInput.getCreated_date());

        return userIsValid && passwordIsValid && nameIsValid && companyEmailIsValid && personalEmailIsValid &&
                cityIsValid && activeIsValid && createDate;

    }


}
