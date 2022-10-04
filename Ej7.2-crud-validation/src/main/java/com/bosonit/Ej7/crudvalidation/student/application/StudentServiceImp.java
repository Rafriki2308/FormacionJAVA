package com.bosonit.Ej7.crudvalidation.student.application;

import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.input.StudentInput;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output.StudentOutputDto;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output.StudentOutputFullDto;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output.StudentOutputSimpleDto;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output.StudentResponseDto;
import com.bosonit.Ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.Ej7.crudvalidation.person.domain.Person;
import com.bosonit.Ej7.crudvalidation.student.domain.Student;
import com.bosonit.Ej7.crudvalidation.person.infraestructure.repository.PersonRepository;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private StudentResponseDto studentDtoResponse;

    public StudentOutputFullDto addStudent(StudentInput studentDtoInput, String idPersona) throws EntityNotFoundException {

        Person person = personRepository.findPersonaById(idPersona);
        if(person==null) {
            throw new EntityNotFoundException("La persona no ha sido encontrado");
        }
        if(person.getProfessor()!=null){
            throw new EntityNotFoundException("Esta persona es un profesor");
        }
        return new StudentOutputFullDto(studentRepository.save(new Student(studentDtoInput, person)));

    }

    public StudentOutputDto getStudentById(String id, String outputType ) throws EntityNotFoundException {
        if(studentRepository.findStudentById(id)==null) {
            throw new EntityNotFoundException("El estudiante no ha sido encontrado");
        }
        if(outputType.equals("full")) {
            return new StudentOutputFullDto(studentRepository.findStudentById(id));
        } else if (outputType.equals("simple")) {
            return new StudentOutputSimpleDto(studentRepository.findStudentById(id));

        }
        throw new EntityNotFoundException("La opcion de informacion no es correcta");
    }

    public List<StudentOutputFullDto> getAllStudents(){
        return studentDtoResponse.mappingStudentToStudentDtoOutput(studentRepository.findAll());
    }

    public void deleteStudentById(String id) throws EntityNotFoundException{
        if(studentRepository.findStudentById(id)==null) {
            throw new EntityNotFoundException("El estudiante no ha sido encontrado");
        }
        studentRepository.delete(studentRepository.findStudentById(id));
    }

    public StudentOutputFullDto modifyStudent(StudentInput studentDtoInput, String id){
        Person person = personRepository.findPersonaById(id);
        if(person==null) {
            throw new EntityNotFoundException("La persona no se ha encontrado no ha sido encontrado");
        }
        return new StudentOutputFullDto(studentRepository.save(new Student(studentDtoInput, person)));

    }

}
