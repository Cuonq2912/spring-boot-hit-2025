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
@RequestMapping("/v1/students")
public class StudentController {
    StudentService studentService;

    @GetMapping()
    List<StudentResponse> getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping(params = "id")
    StudentResponse getById(@RequestParam Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping(params = "name")
    StudentResponse getByName(@RequestParam String name){
        return studentService.getStudentByName(name);
    }

    // Have an error when using this method
    @GetMapping(params = "className")
    List<StudentResponse> getByClassName(@RequestParam String className){
        return studentService.getStudentsByClassName(className);
    }

    @PostMapping("/create")
    ApiResponse<StudentResponse> createStudent(@RequestBody @Valid StudentCreationRequest request){
        ApiResponse<StudentResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(studentService.createStudent(request));
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    StudentResponse updateStudent(@PathVariable Long id, @RequestBody @Valid StudentUpdateRequest request){
        return studentService.updateStudent(id, request);
    }

    @DeleteMapping("delete/{id}")
    String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Student has been delete";
    }

}
