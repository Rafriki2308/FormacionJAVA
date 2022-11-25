package com.bosonit.Ej15Security.person.application;


import com.bosonit.Ej15Security.exceptions.EntityNotFoundException;
import com.bosonit.Ej15Security.exceptions.UnprocessableEntityException;
import com.bosonit.Ej15Security.person.domain.Person;
import com.bosonit.Ej15Security.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej15Security.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej15Security.person.infraestructure.controller.output.PersonResponseDto;
import com.bosonit.Ej15Security.person.infraestructure.repository.PersonRepository;
import com.bosonit.Ej15Security.security.userDetail.UserDetailImpl;
import com.bosonit.Ej15Security.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService, UserDetailsService {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final Validator validator;

    @Autowired
    private final PersonResponseDto personResponseDto;


    public PersonOutputDto addPerson(PersonInputDto personDtoInput) throws UnprocessableEntityException {
        if (validator.checkPersonDtoInput(personDtoInput)) {
            personDtoInput.setPassword(new BCryptPasswordEncoder().encode(personDtoInput.getPassword()));
            return new PersonOutputDto(personRepository.save(new Person(personDtoInput)));

        }
        throw new UnprocessableEntityException("Datos no válidos");
    }

    public PersonOutputDto getPersonById(Integer id) throws EntityNotFoundException {
        Person person = personRepository.findPersonaByIdPerson(id);
        if (person == null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }
        return new PersonOutputDto(person);
    }

    public List<PersonOutputDto> getPersonByName(String name) {
        List<Person> listPerson = new ArrayList<>(personRepository.findByName(name));

        if (listPerson.size() < 1) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }
        return personResponseDto.mappingPersonToPersonDtoOutput(listPerson);
    }

    public List<PersonOutputDto> getAllPeople() {
        List<Person> listPeople = personRepository.findAll();

        if (listPeople.size() < 1) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }
        return personResponseDto.mappingPersonToPersonDtoOutput(listPeople);
    }

    @Override
    //Este metodo lo incluimos para ver que security tome el usuario de la BD, implementa de UserDetailsService
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person person = personRepository.findByUsername(username);

        if (person.equals(null)) {
            throw new UsernameNotFoundException("El usuario" + username + "no existe");
        }

        return new UserDetailImpl(person);
    }

    public void deletePersonById(Integer id) {
        Person person = personRepository.findPersonaByIdPerson(id);
        if (person == null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }
        personRepository.delete(personRepository.findPersonaByIdPerson(id));
    }

    public PersonOutputDto modifyPerson(PersonInputDto personDtoInput, Integer idPerson) {

        if (personRepository.findPersonaByIdPerson(idPerson) == null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }

        if (validator.checkPersonDtoInput(personDtoInput)) {
            personDtoInput.setPassword(new BCryptPasswordEncoder().encode(personDtoInput.getPassword()));
            return new PersonOutputDto(personRepository.save(new Person(personDtoInput, idPerson)));
        }
        throw new UnprocessableEntityException("Datos no válidos");
    }
}
