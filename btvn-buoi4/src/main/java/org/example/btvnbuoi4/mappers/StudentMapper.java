package org.example.btvnbuoi4.mappers;

import org.example.btvnbuoi4.dtos.requests.student.StudentCreationRequest;
import org.example.btvnbuoi4.dtos.requests.student.StudentUpdateRequest;
import org.example.btvnbuoi4.dtos.responses.StudentResponse;
import org.example.btvnbuoi4.models.Students;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Students toStudent(StudentCreationRequest request);
    StudentResponse toStudentResponse(Students students);
    void updateStudent(@MappingTarget Students students, StudentUpdateRequest request);
    List<StudentResponse> toListStudentResponse(List<Students> students);
}
