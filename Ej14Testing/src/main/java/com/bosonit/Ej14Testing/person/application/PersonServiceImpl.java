package com.bosonit.Ej14Testing.person.application;


import com.bosonit.Ej14Testing.exceptions.EntityNotFoundException;
import com.bosonit.Ej14Testing.exceptions.UnprocessableEntityException;
import com.bosonit.Ej14Testing.person.domain.Person;
import com.bosonit.Ej14Testing.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej14Testing.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej14Testing.person.infraestructure.controller.output.PersonResponseDto;
import com.bosonit.Ej14Testing.person.infraestructure.repository.PersonRepository;
import com.bosonit.Ej14Testing.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    @Autowired

    private final PersonRepository personRepository;

    @Autowired
    private final Validator validator;

    @Autowired
    private final PersonResponseDto personResponseDto;


    public PersonOutputDto addPerson(PersonInputDto personDtoInput) throws UnprocessableEntityException {
        if(validator.checkPersonDtoImput(personDtoInput)){
             return new PersonOutputDto(personRepository.save(new Person(personDtoInput)));
        }
        throw new UnprocessableEntityException("Datos no válidos");
    }

    public PersonOutputDto getPersonById(Integer id) throws EntityNotFoundException {
        Person person = personRepository.findPersonaById(id);
        if(person==null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }
        return new PersonOutputDto(person);
    }

    public List<PersonOutputDto> getPersonByUser(String name){
        List<Person> listPerson = new ArrayList<>(personRepository.findByUser(name));

        if(listPerson==null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }
        return personResponseDto.mappingPersonToPersonDtoOutput(listPerson);
    }

    public List<PersonOutputDto> getAllPeople(){
         List<Person> listPeople = personRepository.findAll();

        if(listPeople==null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }
        return personResponseDto.mappingPersonToPersonDtoOutput(listPeople);
    }

    public void deletePersonById(Integer id){
        Person person = personRepository.findPersonaById(id);
        if(person==null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }
        personRepository.delete(personRepository.findPersonaById(id));
    }

    public PersonOutputDto modifyPerson(PersonInputDto personDtoInput, Integer idPerson){

        if(personRepository.findPersonaById(idPerson)==null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }

        if(validator.checkPersonDtoImput(personDtoInput)){
            return new PersonOutputDto(personRepository.save(new Person(personDtoInput,idPerson)));
        }
        throw new UnprocessableEntityException("Datos no válidos");
    }
}
