package com.bosonit.Ej7.crudvalidation.professor.application;

import com.bosonit.Ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.Output.ProfessorOutputFullDto;
import com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.input.ProfessorInputDto;

import java.util.List;

public interface ProfessorService {
    public Object addProfessor(ProfessorInputDto professorInputDto, String idPersona) throws EntityNotFoundException;

    public Object getProfessorById(String id) throws EntityNotFoundException;

    public List<ProfessorOutputFullDto> getAllProfessors()throws EntityNotFoundException;

    public void deleteProfessorById(String idProfessor);

    public ProfessorOutputFullDto modifyProfessor(ProfessorInputDto professorInputDto, String idPersona);
}
