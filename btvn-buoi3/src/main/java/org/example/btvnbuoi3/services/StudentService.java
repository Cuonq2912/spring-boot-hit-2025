package org.example.btvnbuoi3.services;

import org.example.btvnbuoi3.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();
    void creatStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);
    Student getStudentByID(Long id);
}
