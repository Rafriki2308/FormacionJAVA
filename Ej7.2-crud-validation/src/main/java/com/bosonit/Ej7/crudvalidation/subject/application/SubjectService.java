package com.bosonit.Ej7.crudvalidation.subject.application;

import com.bosonit.Ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Input.SubjectInputDto;
import com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Output.SubjectOutputDto;

import java.util.List;

public interface SubjectService {

    public SubjectOutputDto addSubject(SubjectInputDto subjectInputDto);

    public SubjectOutputDto getSubjectById(String id) throws EntityNotFoundException;
    public List<SubjectOutputDto> getAllSubjects()throws EntityNotFoundException;

    public void deleteSubjectById(String idSubject);

    public SubjectOutputDto modifySubject(SubjectInputDto subjectInputDto, String idSubject);
}
