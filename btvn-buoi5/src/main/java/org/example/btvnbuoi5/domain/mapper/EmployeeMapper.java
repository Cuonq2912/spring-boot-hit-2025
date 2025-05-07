package org.example.btvnbuoi5.domain.mapper;

import org.example.btvnbuoi5.domain.dto.EmployeeCreateDto;
import org.example.btvnbuoi5.domain.dto.EmployeeDto;
import org.example.btvnbuoi5.domain.dto.EmployeeUpdateDto;
import org.example.btvnbuoi5.domain.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEmployee(EmployeeCreateDto employeeDto);
    EmployeeDto toEmployeeDto(Employee employee);
    void updateEmployee(@MappingTarget Optional<Employee> employee, EmployeeUpdateDto employeeDto);
    List<EmployeeDto> toEmployeeDtoList(List<Employee> employees);
}
