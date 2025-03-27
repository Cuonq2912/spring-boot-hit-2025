package org.example.btvnbuoi3.services;

import org.example.btvnbuoi3.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudent();
    void saveStudent(Student student);
    void deleteStudent(Long id);
    void updateStudent(Long id, Student updatedStudent);
    Student getStudentByID(Long id);
}
