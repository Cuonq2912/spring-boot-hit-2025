package org.example.btvnbuoi4.mappers;

import org.example.btvnbuoi4.dtos.requests.classes.ClassesCreationRequest;
import org.example.btvnbuoi4.dtos.requests.classes.ClassesUpdateRequest;
import org.example.btvnbuoi4.dtos.responses.ClassesResponse;
import org.example.btvnbuoi4.models.Classes;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassesMapper {
     Classes toClasses(ClassesCreationRequest request);
     ClassesResponse toClassesResponse(Classes classes);
     void updateClasses(@MappingTarget Classes classes, ClassesUpdateRequest request);
     List<ClassesResponse> toListClassesResponse(List<Classes> classes);
}
