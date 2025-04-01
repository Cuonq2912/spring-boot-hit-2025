package org.example.btvnbuoi4.services;

import org.example.btvnbuoi4.dtos.requests.classes.ClassesCreationRequest;
import org.example.btvnbuoi4.dtos.requests.classes.ClassesUpdateRequest;
import org.example.btvnbuoi4.dtos.responses.ClassesResponse;

import java.util.List;

public interface ClassesService {
    ClassesResponse createClass(ClassesCreationRequest request);
    ClassesResponse updateClass(Long id, ClassesUpdateRequest request);
    List<ClassesResponse> getAllClasses();
    ClassesResponse getClassById(Long id);
    void deleteClass(Long id);
}
