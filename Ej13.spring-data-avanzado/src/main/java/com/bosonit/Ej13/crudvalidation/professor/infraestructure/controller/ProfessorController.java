package com.bosonit.Ej13.crudvalidation.professor.infraestructure.controller;

import com.bosonit.Ej13.crudvalidation.professor.application.ProfessorServiceImpl;
import com.bosonit.Ej13.crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.Ej13.crudvalidation.professor.infraestructure.controller.Output.ProfessorOutputDto;
import com.bosonit.Ej13.crudvalidation.professor.infraestructure.controller.Output.ProfessorOutputFullDto;
import com.bosonit.Ej13.crudvalidation.professor.infraestructure.controller.input.ProfessorInputDto;
import com.bosonit.Ej13.crudvalidation.student.infraestructure.controller.output.StudentOutputSimpleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfessorController {

    @Autowired
    private ProfessorServiceImpl professorService;

    @PostMapping("/{idPersona}")
    public ProfessorOutputFullDto addProfessor(@RequestBody ProfessorInputDto professorInputDto, @PathVariable String idPersona) throws UnprocessableEntityException {
        try {
            return professorService.addProfessor(professorInputDto, idPersona);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id_professor}")
    public ProfessorOutputDto getProfessorById(@PathVariable String id_professor){

        return professorService.getProfessorById(id_professor);
    }

    @GetMapping("/profesores")
    public List<ProfessorOutputFullDto> getAllProfessors(){return professorService.getAllProfessors();}

    @GetMapping("/allStudents/{idProfessor}")
    public List<StudentOutputSimpleDto> getAllStudetsByIdProfessor(@PathVariable String idProfessor){
        return professorService.getAllStudentByIdProfessor(idProfessor);}

    @DeleteMapping("/{id_profesor}")
    public void deleteProfessortById(@PathVariable String id_profesor){
        professorService.deleteProfessorById(id_profesor);
    }

    @PutMapping("/{id_persona}")
    public ProfessorOutputFullDto updateProfessor(@RequestBody ProfessorInputDto professorInputDto, @PathVariable String id_persona){
        return professorService.modifyProfessor(professorInputDto, id_persona);
    }
}
