package org.example.btvnbuoi5.domain.mapper;

import org.example.btvnbuoi5.domain.dto.EmployeeCreateDto;
import org.example.btvnbuoi5.domain.dto.EmployeeDto;
import org.example.btvnbuoi5.domain.dto.EmployeeUpdateDto;
import org.example.btvnbuoi5.domain.entity.Employee;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = EmployeeMapperHelper.class)
public interface EmployeeMapper {

    @Mapping(target = "department", source = "departmentId", qualifiedByName = "mapDepartment")
    @Mapping(target = "position", source = "positionId", qualifiedByName = "mapPosition")
    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUser")
    Employee toEmployee(EmployeeCreateDto employeeDto);

    @Mapping(target = "departmentId", source = "department.id")
    @Mapping(target = "positionId", source = "position.id")
    @Mapping(target = "userId", source = "user.id")
    EmployeeDto toEmployeeDto(Employee employee);

    @Mapping(target = "department", source = "departmentId", qualifiedByName = "mapDepartment")
    @Mapping(target = "position", source = "positionId", qualifiedByName = "mapPosition")
    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUser")
    void updateEmployeeFromDto(EmployeeUpdateDto employeeDto, @MappingTarget Employee employee);
    List<EmployeeDto> toEmployeeDtoList(List<Employee> employees);
}