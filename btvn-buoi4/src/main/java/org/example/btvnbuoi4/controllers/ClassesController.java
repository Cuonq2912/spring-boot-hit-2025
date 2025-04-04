package org.example.btvnbuoi4.controllers;

import jakarta.validation.Valid;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi4.dtos.requests.classes.ClassesCreationRequest;
import org.example.btvnbuoi4.dtos.requests.classes.ClassesUpdateRequest;
import org.example.btvnbuoi4.dtos.responses.ApiResponse;
import org.example.btvnbuoi4.dtos.responses.ClassesResponse;
import org.example.btvnbuoi4.services.ClassesService;
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
@RequestMapping("/v1/classes")
public class ClassesController {

    ClassesService classesService;

    @PostMapping("/create")
     ResponseEntity<ApiResponse<ClassesResponse>> addClass(@RequestBody @Valid ClassesCreationRequest request) {
        ClassesResponse classesResponse = classesService.addClass(request);
        ApiResponse<ClassesResponse> apiResponse = ApiResponse.<ClassesResponse>builder()
                .status(CREATED.value())
                .message("Class has been created successfully!!!")
                .timestamp(LocalDateTime.now())
                .data(classesResponse)
                .build();
        return new ResponseEntity<>(apiResponse, CREATED);
    }

    @GetMapping()
    ResponseEntity<ApiResponse<List<ClassesResponse>>> getAllClasses(){
        List<ClassesResponse> classesResponse = classesService.getAllClasses();
        ApiResponse<List<ClassesResponse>> apiResponse = ApiResponse.<List<ClassesResponse>>builder()
                .status(OK.value())
                .message("Get all class successfully!")
                .timestamp(LocalDateTime.now())
                .data(classesResponse)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, OK);
    }

    @GetMapping(params = "id")
    ResponseEntity<ApiResponse<ClassesResponse>> getClassById(@RequestParam Long id){
        ClassesResponse classesResponse = classesService.getClassById(id);
        ApiResponse<ClassesResponse> apiResponse = ApiResponse.<ClassesResponse>builder()
                .status(OK.value())
                .message("Get class by id successfully!")
                .data(classesResponse)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, OK);
    }

    @PutMapping("update/{id}")
    ResponseEntity<ApiResponse<ClassesResponse>> updateClass(@PathVariable Long id, @RequestBody @Valid ClassesUpdateRequest request){
        ClassesResponse classesResponse = classesService.updateClass(id, request);
        ApiResponse<ClassesResponse> apiResponse = ApiResponse.<ClassesResponse>builder()
                .status(OK.value())
                .message("Update class successfully")
                .data(classesResponse)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, OK);
    }

    @DeleteMapping("delete/{id}")
    ResponseEntity<ApiResponse<Void>> deleteClass(@PathVariable Long id){
        classesService.deleteClass(id);
        ApiResponse<Void> apiResponse = ApiResponse.<Void>builder()
                .status(NO_CONTENT.value())
                .message("Delete class successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, NO_CONTENT);
    }

}
