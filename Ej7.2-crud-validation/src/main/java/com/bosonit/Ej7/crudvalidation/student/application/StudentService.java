package com.bosonit.Ej7.crudvalidation.student.application;

import com.bosonit.Ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.input.StudentInputDto;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output.StudentOutputFullDto;

import java.util.List;

public interface StudentService {

    public Object getStudentById(String id, String outputType ) throws EntityNotFoundException;

    public List<StudentOutputFullDto> getAllStudents();

    public void deleteStudentById(String id);

    public StudentOutputFullDto modifyStudent(StudentInputDto studentDtoInput, String id);
}
