package com.bosonit.Ej15Security.person.application;

import com.bosonit.Ej15Security.exceptions.EntityNotFoundException;
import com.bosonit.Ej15Security.exceptions.UnprocessableEntityException;
import com.bosonit.Ej15Security.person.domain.Person;
import com.bosonit.Ej15Security.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej15Security.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej15Security.person.infraestructure.controller.output.PersonResponseDto;
import com.bosonit.Ej15Security.person.infraestructure.repository.PersonRepository;
import com.bosonit.Ej15Security.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private Validator validator;

    @InjectMocks //Mocks solo simula la clase, InjectMocks la instancia correctamente
    private PersonResponseDto personResponseDto;
    @InjectMocks
    private PersonServiceImpl underTest;

    private PersonInputDto personInputDtoTest;

    private Person personTest;

    private Date date = new Date();


    @BeforeEach
    void setUp() {
        underTest = new PersonServiceImpl(personRepository, validator, personResponseDto);
        personInputDtoTest = new PersonInputDto(
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
                date
        );
        personTest = new Person(personInputDtoTest);
    }

    @Test
    void canAddPerson() {
        //When
        //Esta linea obliga a personRepository.save a devolver lo mismo que le ponemos en when
        when(personRepository.save(personTest)).thenReturn(personTest);
        PersonOutputDto personOutputDtoCaptured = underTest.addPerson(personInputDtoTest);
        //Esta linea verifica que hay interaccion con el repositorio
        verify(personRepository).save(personTest);
        //Then
        assertThat(personOutputDtoCaptured).isEqualTo(new PersonOutputDto(personTest));

    }

    @Test
    void whenAddBadFormedPersonThrowsException() {

        //Given
        PersonInputDto personTest2 = new PersonInputDto(
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
                date
        );

        //Then
        assertThrows(UnprocessableEntityException.class, () -> underTest.addPerson(personTest2));
    }

    @Test
    void canGetPersonById() {
        //Given
        personTest.setIdPerson(1);
        Integer id = 1;

        //When
        //Esta linea asegura que cuando relice la peticion a la base de datos me devuelva personTest
        when(personRepository.findPersonaByIdPerson(id)).thenReturn(personTest);

        //Aqui Utilizo el metodo del service y tiene la peticion a repository que me devuelve lo indicado anteriormente
        PersonOutputDto personCaptured = underTest.getPersonById(personTest.getIdPerson());
        //Esta linea lo unico que hace es varificar que se realiza la peticion
        verify(personRepository).findPersonaByIdPerson(id);

        //Then
        Integer idCapturde = personCaptured.getId();
        Assertions.assertEquals(id, idCapturde);

    }

    @Test
    void whenGetPersonByIdGetNullThrowsException() {
        //Given
        personTest.setIdPerson(1);
        Integer id = 1;

        //When
        //Esta linea asegura que cuando relice la peticion a la base de datos me devuelva un null
        when(personRepository.findPersonaByIdPerson(id)).thenReturn(null);

        //When
        //Esta linea certifica que si la persona es nula, el metodo lanza excepcion
        assertThrows(EntityNotFoundException.class, () -> underTest.getPersonById(id));

        //Esta linea lo unico que hace es varificar que se realiza la peticion
        verify(personRepository).findPersonaByIdPerson(id);
    }

    @Test
    void getPersonByUser() {

        //Given
        List<Person> peopleToTest = new ArrayList<>();
        peopleToTest.add(personTest);
        peopleToTest.add(personTest);
        String userToFind = "usuario";

        //When
        when(personRepository.findByName(userToFind)).thenReturn(peopleToTest);

        //Aqui Utilizo el metodo del service y tiene la peticion a repository que me devuelve lo indicado anteriormente
        List<PersonOutputDto> peopleCaptured = underTest.getPersonByName(userToFind);

        //Esta linea lo unico que hace es varificar que se realiza la peticion
        verify(personRepository).findByName(userToFind);

        //Then
        Assertions.assertEquals(2, peopleCaptured.size());

    }

    @Test
    void whenGetPersonByUserReturnNullThrowException() {

        //Given
        String userToFind = "usuario";
        List<Person> peopleToTest = new ArrayList<>();

        //When
        //En este caso cuando se consulta al repositorio devuelve un List vacio
        when(personRepository.findByName(userToFind)).thenReturn(peopleToTest);

        //Then
        //En esta linea mediante lambda usuamos el metodo y vemos que lanza excepcion
        Assertions.assertThrows(EntityNotFoundException.class, () -> underTest.getPersonByName(userToFind));
        verify(personRepository).findByName(userToFind);

    }

    @Test
    void canGetAllPeople() {

        //Given
        List<Person> peopleToTest = new ArrayList<>();
        peopleToTest.add(personTest);
        peopleToTest.add(personTest);

        //When
        when(personRepository.findAll()).thenReturn(peopleToTest);
        List<PersonOutputDto> personOutputDtos = underTest.getAllPeople();
        verify(personRepository).findAll();

        //Then
        Assertions.assertEquals(2, personOutputDtos.size());
    }

    @Test
    void whenGetAllPersonReturnNullThrowException() {

        //Given
        List<Person> peopleToTest = new ArrayList<>();

        //When
        //En este caso cuando se consulta al repositorio devuelve un List vacio
        when(personRepository.findAll()).thenReturn(peopleToTest);

        //Then
        //En esta linea mediante lambda usuamos el metodo y vemos que lanza excepcion
        Assertions.assertThrows(EntityNotFoundException.class, () -> underTest.getAllPeople());
        verify(personRepository).findAll();
    }

    @Test
    void canDeletePersonById() {

        //Given
        Integer id = 1;

        //When
        when(personRepository.findPersonaByIdPerson(id)).thenReturn(personTest);
        underTest.deletePersonById(id);

        //Then
        verify(personRepository).delete(personTest);

    }

    @Test
    void whenDeletePersonByIdThrowsException() {

        //Given
        Integer id = 1;

        //When
        when(personRepository.findPersonaByIdPerson(id)).thenReturn(null);

        //Then
        Assertions.assertThrows(EntityNotFoundException.class, () -> underTest.deletePersonById(id));
    }

    @Test
    void canModifyPerson() {

        //Given
        Integer id = 1;
        PersonInputDto personInputDtoTest2 = new PersonInputDto(
                "usuario2",
                "password",
                "name",
                "surname",
                "comany@email.com",
                "personal@emial.com",
                "city",
                true,
                date,
                "image_url",
                date
        );
        Person personTest2 = new Person(personInputDtoTest2);
        personTest2.setIdPerson(1);

        //When
        when(personRepository.findPersonaByIdPerson(id)).thenReturn(personTest);
        when(personRepository.save(personTest2)).thenReturn(personTest2);
        PersonOutputDto personCaptured = underTest.modifyPerson(personInputDtoTest2, id);
        verify(personRepository).save(personTest2);

        //Then
        Assertions.assertEquals(personCaptured, new PersonOutputDto(personTest2));

    }

    @Test
    void whenModifyPersonByIdAndPersonDoesNotExitsThrowsException() {

        //Given
        PersonInputDto personInputDtoTest2 = new PersonInputDto(
                "usuario2",
                "password",
                "name",
                "surname",
                "comany@email.com",
                "personal@emial.com",
                "city",
                true,
                date,
                "image_url",
                date
        );
        Integer id = 1;

        //When
        when(personRepository.findPersonaByIdPerson(id)).thenReturn(null);

        //Then
        Assertions.assertThrows(EntityNotFoundException.class, () -> underTest.modifyPerson(personInputDtoTest2, id));
    }

    @Test
    void whenModifyPersonByIdAndPersonIsNotWellFormedThrowsException() {

        //Given
        Integer id = 1;
        PersonInputDto personInputDtoTest2 = new PersonInputDto(
                "us",
                "password",
                "name",
                "surname",
                "comany@email.com",
                "personal@emial.com",
                "city",
                true,
                date,
                "image_url",
                date
        );
        Person personTest2 = new Person(personInputDtoTest2);
        personTest2.setIdPerson(1);

        //When
        when(personRepository.findPersonaByIdPerson(id)).thenReturn(personTest);

        //Then
        Assertions.assertThrows(UnprocessableEntityException.class, () -> underTest.modifyPerson(personInputDtoTest2, id));
    }
}