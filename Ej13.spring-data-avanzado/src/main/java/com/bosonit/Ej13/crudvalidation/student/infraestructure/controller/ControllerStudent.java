package com.bosonit.Ej13.crudvalidation.student.infraestructure.controller;

import com.bosonit.Ej13.crudvalidation.student.infraestructure.controller.input.StudentInputDto;
import com.bosonit.Ej13.crudvalidation.student.infraestructure.controller.output.StudentOutputDto;
import com.bosonit.Ej13.crudvalidation.student.infraestructure.controller.output.StudentOutputFullDto;
import com.bosonit.Ej13.crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.Ej13.crudvalidation.student.application.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class ControllerStudent {

    @Autowired
    private StudentServiceImp serviceStudentRepository;

    @PostMapping("/{idPersona}")
    public StudentOutputFullDto addStudent(@RequestBody StudentInputDto studentDtoInput, @PathVariable String idPersona) throws UnprocessableEntityException {
        try {
            return serviceStudentRepository.addStudent(studentDtoInput, idPersona);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{id}")
    public StudentOutputDto getStudentById(@PathVariable String id, @RequestParam String outputType){

        return serviceStudentRepository.getStudentById(id, outputType);
    }

    @GetMapping("/all")
    public List<StudentOutputFullDto> getAllStudents(){return serviceStudentRepository.getAllStudents();}


    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable String id){
        serviceStudentRepository.deleteStudentById(id);}

    @PutMapping("/{id}")
    public StudentOutputFullDto updateStudent(@RequestBody StudentInputDto studentDtoInput, @PathVariable String id){
        return serviceStudentRepository.modifyStudent(studentDtoInput, id);
    }

    @PutMapping("/addSubject/{id}")
    public StudentOutputDto addSubjectToStudent(@PathVariable String id, @RequestParam String idSubject){
        return serviceStudentRepository.addSubject(id, idSubject);
    }

    @PutMapping("/addSubjects/{id}")
    public StudentOutputDto addSubjectToStudent(@RequestBody List<String> subjects, @PathVariable String id){
        return serviceStudentRepository.addSubjects(subjects, id);
    }

}
