package org.example.btvnbuoi3.services.Impl;

import org.example.btvnbuoi3.entities.Student;
import org.example.btvnbuoi3.repositories.StudentRepository;
import org.example.btvnbuoi3.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void creatStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
public void updateStudent(Student student) {
        Student updatedStudent = studentRepository.findById(student.getId()).orElse(null);
        updatedStudent.setName(student.getName());
        updatedStudent.setAddress(student.getAddress());
        updatedStudent.setEmail(student.getEmail());
        updatedStudent.setPhoneNumber(student.getPhoneNumber());
        studentRepository.save(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentByID(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}
