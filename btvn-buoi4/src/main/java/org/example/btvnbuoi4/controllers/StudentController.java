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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/v1/students")
public class StudentController {

    StudentService studentService;

    @GetMapping()
    ResponseEntity<ApiResponse<List<StudentResponse>>> getAll(){
        List<StudentResponse> studentResponses = studentService.getAllStudents();
        ApiResponse<List<StudentResponse>> apiResponse = ApiResponse.<List<StudentResponse>>builder()
                .status(OK.value())
                .message("Get all students successfully")
                .data(studentResponses)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(params = "id")
    ResponseEntity<ApiResponse<StudentResponse>> getById(@RequestParam Long id){
        StudentResponse studentResponse = studentService.getStudentById(id);
        ApiResponse<StudentResponse> apiResponse = ApiResponse.<StudentResponse>builder()
                .status(OK.value())
                .message("Get student by id successfully")
                .data(studentResponse)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(params = "name")
    ResponseEntity<ApiResponse<StudentResponse>> getByName(@RequestParam String name){
        StudentResponse studentResponse = studentService.getStudentByName(name);
        ApiResponse<StudentResponse> apiResponse = ApiResponse.<StudentResponse>builder()
                .status(OK.value())
                .message("Get student by name successfully")
                .data(studentResponse)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @GetMapping(params = "className")
        ResponseEntity<ApiResponse<List<StudentResponse>>> getByClassName(@RequestParam String className){
        List<StudentResponse> studentResponses = studentService.getStudentsByClassName(className);
        ApiResponse<List<StudentResponse>> apiResponse = ApiResponse.<List<StudentResponse>>builder()
                .status(OK.value())
                .message("Get students by class name successfully")
                .data(studentResponses)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @PostMapping("/create")
    ResponseEntity<ApiResponse<StudentResponse>> createStudent(@RequestBody @Valid StudentCreationRequest request){
        StudentResponse studentResponse = studentService.createStudent(request);
        ApiResponse<StudentResponse> apiResponse = ApiResponse.<StudentResponse>builder()
                .status(CREATED.value())
                .message("Student has been created successfully")
                .data(studentResponse)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    ResponseEntity<ApiResponse<StudentResponse>> updateStudent(@PathVariable Long id, @RequestBody @Valid StudentUpdateRequest request){
        StudentResponse studentResponse = studentService.updateStudent(id, request);
        ApiResponse<StudentResponse> apiResponse = ApiResponse.<StudentResponse>builder()
                .status(OK.value())
                .message("Student has been updated successfully")
                .data(studentResponse)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        ApiResponse<Void> apiResponse = ApiResponse.<Void>builder()
                .status(NO_CONTENT.value())
                .message("Student has been deleted successfully")
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.NO_CONTENT);
    }
}
