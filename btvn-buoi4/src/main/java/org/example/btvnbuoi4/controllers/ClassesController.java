package org.example.btvnbuoi4.controllers;

import jakarta.validation.Valid;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi4.dtos.requests.classes.ClassesCreationRequest;
import org.example.btvnbuoi4.dtos.requests.classes.ClassesUpdateRequest;
import org.example.btvnbuoi4.dtos.responses.ApiResponse;
import org.example.btvnbuoi4.dtos.responses.ClassesResponse;
import org.example.btvnbuoi4.services.ClassesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/v1/classes")
public class ClassesController {
    ClassesService classesService;

    @PostMapping("/create")
    ApiResponse<ClassesResponse> addClass(@RequestBody @Valid ClassesCreationRequest request){
        ApiResponse<ClassesResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(classesService.addClass(request));
        return apiResponse;
    }

    @GetMapping()
    List<ClassesResponse> getAllClasses(){
        return classesService.getAllClasses();
    }

    @GetMapping(params = "id")
    ClassesResponse getClassById(@RequestParam Long id){
        return classesService.getClassById(id);
    }

    @PutMapping("update/{id}")
    ClassesResponse updateClass(@PathVariable Long id, @RequestBody @Valid ClassesUpdateRequest request){
        return classesService.updateClass(id, request);
    }

    @DeleteMapping("delete/{id}")
    String deleteClass(@PathVariable Long id){
        classesService.deleteClass(id);
        return "Class has been deleted";
    }

}
