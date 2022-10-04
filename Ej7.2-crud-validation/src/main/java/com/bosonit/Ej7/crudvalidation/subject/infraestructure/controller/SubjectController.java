package com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller;

import com.bosonit.Ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.Ej7.crudvalidation.subject.application.SubjectServiceImp;
import com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Input.SubjectInputDto;
import com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Output.SubjectOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class SubjectController {

    @Autowired
    private SubjectServiceImp subjectServiceImp;

    @PostMapping("")
    public SubjectOutputDto addSubject(@RequestBody SubjectInputDto subjectInputDto) throws UnprocessableEntityException {
        try {
            return subjectServiceImp.addSubject(subjectInputDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/{id}")
    public SubjectOutputDto getSubjectById(@PathVariable String id){

        return subjectServiceImp.getSubjectById(id);
    }

    @GetMapping("/all")
    public List<SubjectOutputDto> getAllSubjects(){return subjectServiceImp.getAllSubjects();}

    @DeleteMapping("/{id}")
    public void deleteSubjectById(@PathVariable String id){
        subjectServiceImp.deleteSubjectById(id);}

    @PutMapping("")
    public SubjectOutputDto updateSubject(@RequestBody SubjectInputDto subjectInputDto){
        return subjectServiceImp.modifySubject(subjectInputDto);
    }
}
