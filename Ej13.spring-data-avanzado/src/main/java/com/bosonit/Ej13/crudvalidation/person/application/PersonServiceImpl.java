package com.bosonit.Ej13.crudvalidation.person.application;

import com.bosonit.Ej13.crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.Ej13.crudvalidation.feignClients.ProfessorFeignClient;
import com.bosonit.Ej13.crudvalidation.person.domain.Person;
import com.bosonit.Ej13.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej13.crudvalidation.person.infraestructure.controller.output.*;
import com.bosonit.Ej13.crudvalidation.person.infraestructure.repository.CriteriaPersonRepository;
import com.bosonit.Ej13.crudvalidation.person.infraestructure.repository.PersonRepository;
import com.bosonit.Ej13.crudvalidation.professor.infraestructure.controller.Output.ProfessorOutputFullDto;
import com.bosonit.Ej13.crudvalidation.validator.Validator;
import com.bosonit.Ej13.crudvalidation.exceptions.UnprocessableEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final PersonResponseDto personDtoResponse;

    @Autowired
    private final Validator validator;

    @Autowired
    private final ProfessorFeignClient professorFeignClient;

    @Autowired
    private final CriteriaPersonRepository criteriaPersonRepository;

    public PersonOutputDto addPerson(PersonInputDto personDtoInput) throws UnprocessableEntityException {
        if (validator.checkPersonDtoImput(personDtoInput)) {
            return new PersonOutputDto(personRepository.save(new Person(personDtoInput)));
        }
        throw new UnprocessableEntityException("Datos no válidos");
    }

    public PersonOutputFatherDto getPersonById(String id, String outputType) throws EntityNotFoundException {
        Person person = personRepository.findPersonaById(id);
        if (person == null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }

        if (outputType.equals("full")) {
            if (person.getProfessor() == null && person.getStudent() == null) {
                return new PersonOutputDto(person);
            } else if (person.getStudent() == null) {
                return new PersonOutputProfessorDto(person);
            } else {
                return new PersonOutputStudentDto(person);
            }
        } else if (outputType.equals("simple")) {
            return new PersonOutputDto(personRepository.findPersonaById(id));
        }
        throw new EntityNotFoundException("La opcion de informacion no es correcta");

    }

    public List<PersonOutputFatherDto> getPersonByUser(String name, String outputType) {
        List<Person> listPerson = new ArrayList<>(personRepository.findByUser(name));

        if (listPerson == null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }

        if (outputType.equals("full")) {
            return personDtoResponse.mappingPersonToPersonDtoOutputFull(listPerson);
        } else if (outputType.equals("simple")) {
            return personDtoResponse.mappingPersonToPersonDtoOutputSimple(listPerson);
        }
        throw new EntityNotFoundException("La opción de información no es correcta");

    }

    public List<PersonOutputFatherDto> getAllPeople(String outputType) {
        List<Person> listPeople = personRepository.findAll();

        if (listPeople == null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }

        if (outputType.equals("full")) {
            return personDtoResponse.mappingPersonToPersonDtoOutputFull(listPeople);
        } else if (outputType.equals("simple")) {
            return personDtoResponse.mappingPersonToPersonDtoOutputSimple(listPeople);
        }
        throw new EntityNotFoundException("La opción de información no es correcta");

    }

    public List<PersonOutputFatherDto> getGreaterPeopleByUser(String user) {

        List<Person> listPeople = criteriaPersonRepository.getGreaterPeopleByUser(user);

        if (listPeople == null) {
            throw new EntityNotFoundException("No se han encontrado personas que cumplan ese criterio");
        }
        return personDtoResponse.mappingPersonToPersonDtoOutputSimple(listPeople);

    }

    public List<PersonOutputFatherDto> getLessPeopleByUser(String user) {

        List<Person> listPeople = criteriaPersonRepository.getLessPeopleByUser(user);

        if (listPeople == null) {
            throw new EntityNotFoundException("No se han encontrado personas que cumplan ese criterio");
        }
        return personDtoResponse.mappingPersonToPersonDtoOutputSimple(listPeople);

    }

    public List<PersonOutputFatherDto> getGreaterPeopleByName(String name) {

        List<Person> listPeople = criteriaPersonRepository.getGreaterPeopleByName(name);

        if (listPeople == null) {
            throw new EntityNotFoundException("No se han encontrado personas que cumplan ese criterio");
        }
        return personDtoResponse.mappingPersonToPersonDtoOutputSimple(listPeople);
    }

    public List<PersonOutputFatherDto> getLessPeopleByName(String name) {

        List<Person> listPeople = criteriaPersonRepository.getLessPeopleByName(name);

        if (listPeople == null) {
            throw new EntityNotFoundException("No se han encontrado personas que cumplan ese criterio");
        }
        return personDtoResponse.mappingPersonToPersonDtoOutputSimple(listPeople);
    }

    public List<PersonOutputFatherDto> getGreaterPeopleBySurname(String surname) {

        List<Person> listPeople = criteriaPersonRepository.getGreaterPeopleBySurname(surname);

        if (listPeople == null) {
            throw new EntityNotFoundException("No se han encontrado personas que cumplan ese criterio");
        }
        return personDtoResponse.mappingPersonToPersonDtoOutputSimple(listPeople);
    }

    public List<PersonOutputFatherDto> getLessPeopleBySurname(String surname) {

        List<Person> listPeople = criteriaPersonRepository.getLessPeopleBySurname(surname);

        if (listPeople == null) {
            throw new EntityNotFoundException("No se han encontrado personas que cumplan ese criterio");
        }
        return personDtoResponse.mappingPersonToPersonDtoOutputSimple(listPeople);
    }

    public List<PersonOutputFatherDto> getGreaterPeopleByDateCreate(Date dateCreated) {

        List<Person> listPeople = criteriaPersonRepository.getGreaterPeopleByDateCreation(dateCreated);

        if (listPeople == null) {
            throw new EntityNotFoundException("No se han encontrado personas que cumplan ese criterio");
        }
        return personDtoResponse.mappingPersonToPersonDtoOutputSimple(listPeople);
    }

    public List<PersonOutputFatherDto> getLessPeopleByDateCreate(Date dateCreated) {

        List<Person> listPeople = criteriaPersonRepository.getLessPeopleByDateCreation(dateCreated);

        if (listPeople == null) {
            throw new EntityNotFoundException("No se han encontrado personas que cumplan ese criterio");
        }
        return personDtoResponse.mappingPersonToPersonDtoOutputSimple(listPeople);
    }

    public ProfessorOutputFullDto getProffesorUsingFeign(String idProfessor) {
        return professorFeignClient.getProfessor(idProfessor);
    }

    public void deletePersonById(String id) {
        Person person = personRepository.findPersonaById(id);
        if (person == null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }
        if (person.getStudent() != null || person.getProfessor() != null) {
            throw new EntityNotFoundException("Esta Persona tiene un rol asignado");
        }

        personRepository.delete(personRepository.findPersonaById(id));
    }

    public PersonOutputDto modifyPerson(PersonInputDto personDtoInput, String idPerson) {

        if (personRepository.findPersonaById(idPerson) == null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }

        if (validator.checkPersonDtoImput(personDtoInput)) {
            return new PersonOutputDto(personRepository.save(new Person(personDtoInput, idPerson)));
        }
        throw new UnprocessableEntityException("Datos no válidos");
    }
}
