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
import org.example.btvnbuoi5.domain.entity.Department;
import org.example.btvnbuoi5.domain.entity.Employee;
import org.example.btvnbuoi5.domain.entity.Position;
import org.example.btvnbuoi5.domain.entity.User;
import org.example.btvnbuoi5.domain.mapper.EmployeeMapper;
import org.example.btvnbuoi5.exception.NotFoundException;
import org.example.btvnbuoi5.repository.DepartmentRepository;
import org.example.btvnbuoi5.repository.EmployeeRepository;
import org.example.btvnbuoi5.repository.PositionRepository;
import org.example.btvnbuoi5.repository.UserRepository;
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
    PositionRepository positionRepository;
    DepartmentRepository departmentRepository;
    UserRepository userRepository;
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
        setPositionForEmployee(employee, employeeDto);
        setDepartmentForEmployee(employee, employeeDto);
        setUserForEmployee(employee, employeeDto);
        EmployeeDto employeeDto1 = employeeMapper.toEmployeeDto(employeeRepository.save(employee));
        setPositionForEmployeeDto(employeeDto1, employee);
        setDepartmentForEmployeeDto(employeeDto1, employee);
        setUserForEmployeeDto(employeeDto1, employee);
        return employeeDto1;
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeUpdateDto employeeDto) {
        Optional<Employee> employee = employeeRepository.findById(id);
        checkEmployeeNotFound(employee, id);
        employeeMapper.updateEmployeeFromDto(employeeDto, employee.get());
        return employeeMapper.toEmployeeDto(employeeRepository.save(employee.get()));
    }

    private void setPositionForEmployee(Employee employee, EmployeeCreateDto employeeDto){
        Optional<Position> position = positionRepository.findById(employeeDto.getDepartmentId());
        checkPositionNotFound(position, employeeDto.getDepartmentId());
        employee.setPosition(position.get());
    }

    private void setPositionForEmployeeDto(EmployeeDto employeeDto, Employee employee){
        Optional<Position> position = positionRepository.findById(employee.getPosition().getId());
        checkPositionNotFound(position, employee.getPosition().getId());
        employeeDto.setPositionId(position.get().getId());
    }

    private void setDepartmentForEmployeeDto(EmployeeDto employeeDto, Employee employee){
        Optional<Department> department = departmentRepository.findById(employee.getDepartment().getId());
        checkDepartmentNotFound(department, employee.getDepartment().getId());
        employeeDto.setDepartmentId(department.get().getId());
    }

    private void setUserForEmployeeDto(EmployeeDto employeeDto, Employee employee){
        Optional<User> user = userRepository.findById(employee.getUser().getId());
        checkUserNotFound(user, employee.getUser().getId());
        employeeDto.setUserId(user.get().getId());
    }

    private void setDepartmentForEmployee(Employee employee, EmployeeCreateDto employeeDto){
        Optional<Department> department = departmentRepository.findById(employeeDto.getDepartmentId());
        checkDepartmentNotFound(department, employeeDto.getDepartmentId());
        employee.setDepartment(department.get());
    }

    private void setUserForEmployee(Employee employee, EmployeeCreateDto employeeDto){
        Optional<User> user = userRepository.findById(employeeDto.getUserId());
        checkUserNotFound(user, employeeDto.getUserId());
        employee.setUser(user.get());
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

    private void checkDepartmentNotFound(Optional<Department> department, Long id){
        if(department.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.Department.ERR_NOT_FOUND_ID, id));
        }
    }

    private void checkUserNotFound(Optional<User> user, Long id){
        if(user.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.User.ERR_NOT_FOUND_ID, id));
        }
    }

    private void checkPositionNotFound(Optional<Position> position, Long id){
        if(position.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.Position.ERR_NOT_FOUND_ID, id));
        }
    }

}
