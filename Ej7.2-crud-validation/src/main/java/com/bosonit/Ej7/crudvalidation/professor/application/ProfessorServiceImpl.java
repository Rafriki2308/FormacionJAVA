package com.bosonit.Ej7.crudvalidation.professor.application;

import com.bosonit.Ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.Ej7.crudvalidation.professor.domain.Professor;
import com.bosonit.Ej7.crudvalidation.person.domain.Person;
import com.bosonit.Ej7.crudvalidation.person.infraestructure.repository.PersonRepository;
import com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.Output.ProfessorOutputDto;
import com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.Output.ProfessorOutputFullDto;
import com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.Output.ProfessorOutputResponseDto;
import com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.Output.ProfessorOutputSimpleDto;
import com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.input.ProfessorInputDto;
import com.bosonit.Ej7.crudvalidation.professor.infraestructure.repository.ProfessorRepository;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output.StudentOutputSimpleDto;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output.StudentResponseDto;
import com.bosonit.Ej7.crudvalidation.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service

public class ProfessorServiceImpl implements ProfessorService{


    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ProfessorOutputResponseDto professorOutputResponseDto;

    @Autowired
    private StudentResponseDto studentResponseDto;

    public ProfessorOutputFullDto addProfessor(ProfessorInputDto professorInputDto, String idPersona) throws EntityNotFoundException {

        Person person = personRepository.findPersonaById(idPersona);
        if(person==null) {
            throw new EntityNotFoundException("La persona no ha sido encontrado");
        }
        if(person.getStudent()!=null){
            throw new EntityNotFoundException("Esta persona es un estudiante");
        }
        return new ProfessorOutputFullDto(professorRepository.save(new Professor(professorInputDto, person)));

    }

    public ProfessorOutputDto getProfessorById(String id, String outputType) throws EntityNotFoundException {
         Professor professor = professorRepository.findProfessorById(id);
        if( professor==null) {
            throw new EntityNotFoundException("El profesor no ha sido encontrado");
        }

        if(outputType.equals("full")) {
            return new ProfessorOutputFullDto(professor);
        } else if (outputType.equals("simple")) {
            return new ProfessorOutputSimpleDto(professor);

        }
        throw new EntityNotFoundException("La opcion de informacion no es correcta");
    }

    public List<ProfessorOutputFullDto> getAllProfessors()throws EntityNotFoundException{
        List<Professor> professorList = professorRepository.findAll();

        if( professorList==null) {
            throw new EntityNotFoundException("No se han encontrado profesores");
        }

        return professorOutputResponseDto.mappingProfessorToProfessorOutput(professorList);
    }

    public List<StudentOutputSimpleDto> getAllStudentByIdProfessor(String idProfessor){
        Professor professor = professorRepository.findProfessorById(idProfessor);
        return studentResponseDto.mappingStudentToStudentDtoOutputSimple(professor.getStudents());
    }

    public void deleteProfessorById(String idProfessor){
        Professor professor = professorRepository.findProfessorById(idProfessor);
        if(professor==null) {
            throw new EntityNotFoundException("El professor no ha sido encontrado");
        }
        professorRepository.delete(professor);
    }

    public ProfessorOutputFullDto modifyProfessor(ProfessorInputDto professorInputDto, String idPersona){
        Person person = personRepository.findPersonaById(idPersona);

        if(person==null) {
            throw new EntityNotFoundException("La persona no se ha encontrado no ha sido encontrado");
        }

        return new ProfessorOutputFullDto(professorRepository.save(new Professor(professorInputDto, person)));
    }
}
