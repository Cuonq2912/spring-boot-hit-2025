package org.example.btvnbuoi5.domain.mapper;

import org.example.btvnbuoi5.domain.dto.DepartmentCreateDto;
import org.example.btvnbuoi5.domain.dto.DepartmentDto;
import org.example.btvnbuoi5.domain.dto.DepartmentUpdateDto;
import org.example.btvnbuoi5.domain.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    Department toDepartment(DepartmentCreateDto departmentDto);
    DepartmentDto toDepartmentDto(Department department);
    void updateDepartment(@MappingTarget Optional<Department> department, DepartmentUpdateDto departmentDto);
}
