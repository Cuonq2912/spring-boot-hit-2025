package org.example.btvnbuoi5.service.work;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi5.constant.CommonConstant;
import org.example.btvnbuoi5.constant.CommonMessage;
import org.example.btvnbuoi5.constant.ErrorMessage;
import org.example.btvnbuoi5.domain.dto.EmployeeCreateDto;
import org.example.btvnbuoi5.domain.dto.EmployeeDto;
import org.example.btvnbuoi5.domain.dto.EmployeeUpdateDto;
import org.example.btvnbuoi5.domain.dto.response.CommonResponseDto;
import org.example.btvnbuoi5.domain.entity.Employee;
import org.example.btvnbuoi5.domain.mapper.EmployeeMapper;
import org.example.btvnbuoi5.exception.NotFoundException;
import org.example.btvnbuoi5.repository.EmployeeRepository;
import org.example.btvnbuoi5.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeWork implements EmployeeService {

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;


    @Override
    public List<EmployeeDto> getAllEmployee() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toEmployeeDto)
                .toList();
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        checkEmployeeNotFound(employee, id);
        return employeeMapper.toEmployeeDto(employee.get());
    }

    @Override
    public EmployeeDto createEmployee(EmployeeCreateDto employeeDto) {
        Employee employee = employeeMapper.toEmployee(employeeDto);
        return employeeMapper.toEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeUpdateDto employeeDto) {
        Optional<Employee> employee = employeeRepository.findById(id);
        checkEmployeeNotFound(employee, id);
        employeeMapper.updateEmployeeFromDto(employeeDto, employee.get());
        return employeeMapper.toEmployeeDto(employeeRepository.save(employee.get()));
    }

    @Override
    public CommonResponseDto deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        checkEmployeeNotFound(employee, id);
        employeeRepository.deleteById(id);
        return new CommonResponseDto(CommonConstant.TRUE, CommonMessage.DELETE_SUCCESS);
    }

    @Override
    public List<EmployeeDto> getEmployeesByFullName(String fullName) {
        List<Employee> employee = employeeRepository.findByFullName(fullName);
        if(employee.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.Employee.ERR_NOT_FOUND_FULLNAME, fullName));
        }
        return employeeMapper.toEmployeeDtoList(employee);
    }

    @Override
    public List<EmployeeDto> getEmployeesByDepartmentId(Long departmentId) {
        List<Employee> employee = employeeRepository.findByDepartmentId(departmentId);
        if(employee.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.Employee.ERR_NOT_FOUND_DEPARTMENT_ID, departmentId));
        }
        return employeeMapper.toEmployeeDtoList(employee);
    }

    @Override
    public List<EmployeeDto> getEmployeesByPositionId(Long positionId) {
        List<Employee> employee = employeeRepository.findByPositionId(positionId);
        if(employee.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.Employee.ERR_NOT_FOUND_POSITION_ID, positionId));
        }
        return employeeMapper.toEmployeeDtoList(employee);
    }

    @Override
    public List<EmployeeDto> getEmployeeByMultipleCondition(String fullName, Long departmentId, Long positionId) {
        List<Employee> employee = employeeRepository.findByMultipleCondition(fullName, departmentId, positionId);
        if(employee.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.Employee.ERR_NOT_FOUND));
        }
        return employeeMapper.toEmployeeDtoList(employee);
    }

    private void checkEmployeeNotFound(Optional<Employee> employee, Long id){
        if(employee.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.Employee.ERR_NOT_FOUND_ID, id));
        }
    }

}
