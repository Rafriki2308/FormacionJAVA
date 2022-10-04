package com.bosonit.Ej7.crudvalidation.subject.application;

import com.bosonit.Ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Input.SubjectInputDto;
import com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Output.SubjectOutputDto;
import com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Output.SubjectOutputDtoResponse;
import com.bosonit.Ej7.crudvalidation.subject.infraestructure.repository.SubjectRepository;
import com.bosonit.Ej7.crudvalidation.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectServiceImp implements SubjectService{

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    SubjectOutputDtoResponse subjectOutputDtoResponse;

    public SubjectOutputDto addSubject(SubjectInputDto subjectInputDto){
        return new SubjectOutputDto(subjectRepository.save(new Subject(subjectInputDto)));
    }

    public SubjectOutputDto getSubjectById(String id) throws EntityNotFoundException {

        Subject subject = subjectRepository.findSubjectById(id);
        if( subject==null) {
            throw new EntityNotFoundException("La asignatura no ha sido encontrado");
        }
            return new SubjectOutputDto(subject);
    }

    public List<SubjectOutputDto> getAllSubjects()throws EntityNotFoundException{
        List<Subject> subjectsList = subjectRepository.findAll();

        if( subjectsList==null) {
            throw new EntityNotFoundException("No se han encontrado asignaturas");
        }

        return subjectOutputDtoResponse.mappingSubjectToSubjectOutputDto(subjectsList);
    }

    public void deleteSubjectById(String idSubject){
        Subject subject = subjectRepository.findSubjectById(idSubject);
        if(subject==null) {
            throw new EntityNotFoundException("No se ha encontrado la asignatura");
        }
        subjectRepository.delete(subject);
    }

    public SubjectOutputDto modifySubject(SubjectInputDto subjectInputDto){

        return new SubjectOutputDto(subjectRepository.save(new Subject(subjectInputDto)));
    }
}
