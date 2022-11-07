package com.bosonit.Ej14Testing.validator;

import com.bosonit.Ej14Testing.exceptions.UnprocessableEntityException;
import com.bosonit.Ej14Testing.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej14Testing.validator.Validator;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class ValidatorTest {

    @Autowired
    private Validator validator = new Validator();

    @Test
    public void whenFieldIsNotNullreturnTrue(){
        String fieldTest = "prueba";

        assertThat(validator.checkNullField(fieldTest)).isTrue();
    }
    @Test
    public void whenFieldIsNullThrowException(){
        String fieldTest = "";

        assertThrows(UnprocessableEntityException.class,()->validator.checkNullField(fieldTest));
    }

    @Test
    public void whenFieldDateIsNotNullReturnTrue(){
        Date dateField = new Date();

        assertThat(validator.checkNullFieldDate(dateField)).isTrue();
    }

    @Test
    public void whenFieldDateIsNullThrowException(){

        assertThrows(UnprocessableEntityException.class,()->validator.checkNullFieldDate(null));
    }

    @Test
    public void whenFieldActiveIsNotNullReturnTrue(){
        Boolean fieldTest = true;

        assertThat(validator.checkNullFieldActive(fieldTest)).isTrue();
    }

    @Test
    public void whenFieldActiveIsNullThrowException(){

        assertThrows(UnprocessableEntityException.class,()->validator.checkNullFieldActive(null));
    }

    @Test
    public void whenFieldLengthIsInRangeReturnTrue() throws Exception {
       String fieldTest = "campos";

        assertThat(validator.checkLength(fieldTest)).isTrue();
    }

    @Test
    public void whenFieldLengthIsNotInRangeThrowException(){

        String fieldTest = "campoExcedido";
        assertThrows(UnprocessableEntityException.class,()->validator.checkLength(fieldTest));
    }

    @Test
    public void whenPersonDtoInputIsWellFormedReturnTrue(){
        Date date = new Date();
        Date date2 = new Date();
        PersonInputDto personTest = new PersonInputDto(
                "usuario",
                "password",
                "name",
                "surname",
                "comany@email.com",
                "personal@emial.com",
                "city",
                true,
                date,
                "image_url",
                date2
                );

        assertThat(validator.checkPersonDtoImput(personTest)).isTrue();
    }

    @Test
    public void whenPersonDtoInputIsNotWellFormedThrowException(){
        Date date = new Date();
        Date date2 = new Date();
        PersonInputDto personTest1 = new PersonInputDto(
                "usu",
                "password",
                "name",
                "surname",
                "comany@email.com",
                "personal@emial.com",
                "city",
                true,
                date,
                "image_url",
                date2
        );
        PersonInputDto personTest2 = new PersonInputDto(
                "usurio_extendido",
                "password",
                "name",
                "surname",
                "comany@email.com",
                "personal@emial.com",
                "city",
                true,
                date,
                "image_url",
                date2
        );
        PersonInputDto personTest3 = new PersonInputDto(
                "",
                "password",
                "name",
                "surname",
                "comany@email.com",
                "personal@emial.com",
                "city",
                true,
                date,
                "image_url",
                date2
        );



        assertThrows(UnprocessableEntityException.class,()->validator.checkPersonDtoImput(personTest1));
        assertThrows(UnprocessableEntityException.class,()->validator.checkPersonDtoImput(personTest2));
        assertThrows(UnprocessableEntityException.class,()->validator.checkPersonDtoImput(personTest3));
    }

}