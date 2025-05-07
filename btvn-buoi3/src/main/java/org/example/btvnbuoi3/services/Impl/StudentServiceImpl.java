package org.example.btvnbuoi3.services.Impl;

import org.example.btvnbuoi3.entities.Student;
import org.example.btvnbuoi3.repositories.StudentRepository;
import org.example.btvnbuoi3.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Long id, Student updatedStudent) {
        Student currentStudent = getStudentByID(id);
        currentStudent.setName(updatedStudent.getName());
        currentStudent.setEmail(updatedStudent.getEmail());
        currentStudent.setPhoneNumber(updatedStudent.getPhoneNumber());
        currentStudent.setAddress(updatedStudent.getAddress());
        studentRepository.save(currentStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentByID(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
