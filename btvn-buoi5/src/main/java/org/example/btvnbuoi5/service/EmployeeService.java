package org.example.btvnbuoi5.service;

import org.example.btvnbuoi5.domain.dto.EmployeeCreateDto;
import org.example.btvnbuoi5.domain.dto.EmployeeDto;
import org.example.btvnbuoi5.domain.dto.EmployeeUpdateDto;
import org.example.btvnbuoi5.domain.dto.UserDto;
import org.example.btvnbuoi5.domain.dto.response.CommonResponseDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployee();
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto createEmployee(EmployeeCreateDto employeeDto);
    EmployeeDto updateEmployee(Long id, EmployeeUpdateDto employeeDto);
    CommonResponseDto deleteEmployee(Long id);

    List<EmployeeDto> getEmployeesByFullName(String fullName);
    List<EmployeeDto> getEmployeesByDepartmentId(Long departmentId);
    List<EmployeeDto> getEmployeesByPositionId(Long positionId);
    List<EmployeeDto> getEmployeeByMultipleCondition(String fullName, Long departmentId, Long positionId);
}
