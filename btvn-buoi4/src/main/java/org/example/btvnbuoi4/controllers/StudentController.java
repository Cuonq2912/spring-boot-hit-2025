package org.example.btvnbuoi4.controllers;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi4.dtos.requests.student.StudentCreationRequest;
import org.example.btvnbuoi4.dtos.requests.student.StudentUpdateRequest;
import org.example.btvnbuoi4.dtos.responses.ApiResponse;
import org.example.btvnbuoi4.dtos.responses.StudentResponse;
import org.example.btvnbuoi4.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/students")
public class StudentController {
    StudentService studentService;

    @GetMapping("/getAll")
    List<StudentResponse> getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    StudentResponse getById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/create")
    ApiResponse<StudentResponse> createStudent(@RequestBody @Valid StudentCreationRequest request){
        ApiResponse<StudentResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(studentService.createStudent(request));
        return apiResponse;
    }

    // has a bug in this function
//    @PutMapping("/update/{id}")
//    StudentResponse updateStudent(@PathVariable Long id, @RequestBody @Valid StudentUpdateRequest request){
//        return studentService.updateStudent(id, request);
//    }

    @DeleteMapping("delete/{id}")
    String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Student has been delete";
    }

}
