package org.example.btvnbuoi4.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi4.dtos.requests.student.StudentCreationRequest;
import org.example.btvnbuoi4.dtos.requests.student.StudentUpdateRequest;
import org.example.btvnbuoi4.dtos.responses.StudentResponse;
import org.example.btvnbuoi4.exceptions.AppException;
import org.example.btvnbuoi4.exceptions.ErrorCode;
import org.example.btvnbuoi4.mappers.StudentMapper;
import org.example.btvnbuoi4.models.Classes;
import org.example.btvnbuoi4.models.Students;
import org.example.btvnbuoi4.repositories.ClassesRepository;
import org.example.btvnbuoi4.repositories.StudentRepository;
import org.example.btvnbuoi4.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;
    ClassesRepository classesRepository;
    StudentMapper studentMapper;

    @Override
    public StudentResponse createStudent(StudentCreationRequest request) {
        if(request.getName().length() < 10 || request.getName().length() > 50){
            throw new AppException(ErrorCode.STUDENT_NAME_INVALID);
        }
        if(studentRepository.existsByEmail(request.getEmail())){
            throw new AppException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }
        if(studentRepository.existsByPhoneNumber(request.getPhoneNumber())){
            throw new AppException(ErrorCode.PHONE_NUMBER_ALREADY_EXISTS);
        }
        Classes classes = classesRepository.findById(request.getClassId())
                .orElseThrow(() -> new AppException(ErrorCode.CLASSES_NOT_FOUND));
        Students students = studentMapper.toStudent(request);
        students.setClasses(classes);



        return studentMapper.toStudentResponse( studentRepository.save(students));
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentUpdateRequest request) {
        Students students = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student is not found!!!"));

        Classes classes = classesRepository.findById(request.getClassId())
                        .orElseThrow(() -> new AppException(ErrorCode.CLASSES_NOT_FOUND));

        studentMapper.updateStudent(students, request);
        students.setClasses(classes);
        return studentMapper.toStudentResponse(studentRepository.save(students));
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentMapper.toListStudentResponse(studentRepository.findAll());
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        return studentMapper.toStudentResponse(studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student is not exist!!!")));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponse getStudentByName(String name) {
        Students students = studentRepository.findByName(name);
        return studentMapper.toStudentResponse(students);
    }

    @Override
    public List<StudentResponse> getStudentsByClassName(String className) {
        List<Students> studentsList = studentRepository.findByClasses_Name(className);
        return studentMapper.toListStudentResponse(studentsList);
    }
}
