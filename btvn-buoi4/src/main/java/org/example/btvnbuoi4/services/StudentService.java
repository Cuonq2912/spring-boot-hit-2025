package org.example.btvnbuoi4.services;

import org.example.btvnbuoi4.dtos.requests.student.StudentCreationRequest;
import org.example.btvnbuoi4.dtos.requests.student.StudentUpdateRequest;
import org.example.btvnbuoi4.dtos.responses.StudentResponse;
import org.example.btvnbuoi4.models.Classes;

import java.util.List;

public interface StudentService {
    StudentResponse createStudent(StudentCreationRequest request);
    StudentResponse updateStudent(Long id, StudentUpdateRequest request);
    List<StudentResponse> getAllStudents();
    StudentResponse getStudentById(Long id);
    void deleteStudent(Long id);
    StudentResponse getStudentByName(String name);
    List<StudentResponse> getStudentsByClassName(Classes className);
}
