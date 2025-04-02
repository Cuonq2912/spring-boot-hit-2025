package org.example.btvnbuoi4.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi4.dtos.requests.classes.ClassesCreationRequest;
import org.example.btvnbuoi4.dtos.requests.classes.ClassesUpdateRequest;
import org.example.btvnbuoi4.dtos.responses.ClassesResponse;
import org.example.btvnbuoi4.exceptions.AppException;
import org.example.btvnbuoi4.exceptions.ErrorCode;
import org.example.btvnbuoi4.mappers.ClassesMapper;
import org.example.btvnbuoi4.models.Classes;
import org.example.btvnbuoi4.repositories.ClassesRepository;
import org.example.btvnbuoi4.services.ClassesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClassesServiceImpl implements ClassesService {

    ClassesRepository classesRepository;
    ClassesMapper classesMapper;


    @Override
    public ClassesResponse addClass(ClassesCreationRequest request) {
       if(classesRepository.existsByName(request.getName())){
           throw new AppException(ErrorCode.CLASSES_NAME_EXISTS);
       }
       Classes classes = classesMapper.toClasses(request);
       return classesMapper.toClassesResponse(classesRepository.save(classes));
    }

    @Override
    public ClassesResponse updateClass(Long id, ClassesUpdateRequest request) {
        Classes classes = classesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class is not found"));
        classesMapper.updateClasses(classes, request);
        return classesMapper.toClassesResponse(classesRepository.save(classes));
    }

    @Override
    public List<ClassesResponse> getAllClasses() {
        return classesMapper.toListClassesResponse(classesRepository.findAll());
    }

    @Override
    public ClassesResponse getClassById(Long id) {
        return classesMapper.toClassesResponse(classesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class is not found")));
    }

    @Override
    public void deleteClass(Long id) {
        classesRepository.deleteById(id);
    }

}
