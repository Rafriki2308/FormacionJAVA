package com.bosonit.Ej13.crudvalidation.student.application;

import com.bosonit.Ej13.crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.Ej13.crudvalidation.person.domain.Person;
import com.bosonit.Ej13.crudvalidation.person.infraestructure.repository.PersonRepository;
import com.bosonit.Ej13.crudvalidation.professor.domain.Professor;
import com.bosonit.Ej13.crudvalidation.professor.infraestructure.repository.ProfessorRepository;
import com.bosonit.Ej13.crudvalidation.student.domain.Student;
import com.bosonit.Ej13.crudvalidation.student.infraestructure.controller.input.StudentInputDto;
import com.bosonit.Ej13.crudvalidation.student.infraestructure.controller.output.StudentOutputDto;
import com.bosonit.Ej13.crudvalidation.student.infraestructure.controller.output.StudentOutputFullDto;
import com.bosonit.Ej13.crudvalidation.student.infraestructure.controller.output.StudentOutputSimpleDto;
import com.bosonit.Ej13.crudvalidation.student.infraestructure.controller.output.StudentResponseDto;
import com.bosonit.Ej13.crudvalidation.student.infraestructure.repository.StudentRepository;
import com.bosonit.Ej13.crudvalidation.subject.domain.Subject;
import com.bosonit.Ej13.crudvalidation.subject.infraestructure.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private StudentResponseDto studentDtoResponse;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    ProfessorRepository professorRepository;

    public StudentOutputFullDto addStudent(StudentInputDto studentDtoInput, String idPersona) throws EntityNotFoundException {

        Person person = personRepository.findPersonaById(idPersona);
        if(person==null) {
            throw new EntityNotFoundException("La persona no ha sido encontrado");
        }
        if(person.getProfessor()!=null){
            throw new EntityNotFoundException("Esta persona es un profesor");
        }

        Professor professor = professorRepository.findProfessorById(studentDtoInput.getIdProfessor());
        if(professor==null){
            throw new EntityNotFoundException("El profesor no se ha encontrado");
        }
        Student student = new Student(studentDtoInput, person,professor);
        return new StudentOutputFullDto(studentRepository.save(student));

    }

    public StudentOutputDto addSubject(String idStudent, String idSubject) throws EntityNotFoundException{
        Student student = studentRepository.findStudentById(idStudent);
        if(studentRepository.findStudentById(idStudent)==null) {
            throw new EntityNotFoundException("El estudiante no ha sido encontrado");
        }
        Subject subject = subjectRepository.findSubjectById(idSubject);
        if(subjectRepository.findSubjectById(idSubject)==null) {
            throw new EntityNotFoundException("La asignatura no ha sido encontrado");
        }


        student.addSubjectToSubjecList(subject);
        studentRepository.save(student);
        return new StudentOutputFullDto(student);
    }

    public StudentOutputDto addSubjects (List<String> idSubjects, String idStudent){

        List<Subject> subjects = new ArrayList<>();
        Student student = studentRepository.findStudentById(idStudent);
        if(studentRepository.findStudentById(idStudent)==null) {
            throw new EntityNotFoundException("El estudiante no ha sido encontrado");
        }
        for (String s: idSubjects) {
            Subject subject = subjectRepository.findSubjectById(s);
            if(subjectRepository.findSubjectById(s)==null) {
                throw new EntityNotFoundException("La asignatura no ha sido encontrado");
            }
            subjects.add(subject);
        }
        student.setSubjects(subjects);
        studentRepository.save(student);
        return new StudentOutputFullDto(student);
    }

    public StudentOutputDto getStudentById(String id, String outputType) throws EntityNotFoundException {
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

    public StudentOutputFullDto modifyStudent(StudentInputDto studentDtoInput, String idStudent){

        Student student = studentRepository.findStudentById(idStudent);
        Person person = personRepository.findPersonaById(studentDtoInput.getIdPerson());
        Professor professor= professorRepository.findProfessorById(studentDtoInput.getIdProfessor());

        if(student==null) {
            throw new EntityNotFoundException("Es estudiante no se ha encontrado no ha sido encontrado");
        }

        if(person ==null || person.getStudent()==null){
            throw new EntityNotFoundException("El la persona no es válida");
        }

        if(professor==null){
            throw new EntityNotFoundException("El profesor no es válido");
        }

        return new StudentOutputFullDto(studentRepository.save(new Student(studentDtoInput, person,professor)));

    }

}
