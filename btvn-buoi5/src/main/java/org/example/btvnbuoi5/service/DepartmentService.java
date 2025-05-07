package org.example.btvnbuoi5.service;

import org.example.btvnbuoi5.domain.dto.DepartmentCreateDto;
import org.example.btvnbuoi5.domain.dto.DepartmentDto;
import org.example.btvnbuoi5.domain.dto.DepartmentUpdateDto;
import org.example.btvnbuoi5.domain.dto.response.CommonResponseDto;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDto> getAllDepartment();
    DepartmentDto getDepartmentById(Long id);
    DepartmentDto createDepartment(DepartmentCreateDto departmentDto);
    DepartmentDto updateDepartment(Long id, DepartmentUpdateDto departmentDto);
    CommonResponseDto deleteDepartment(Long id);

}
