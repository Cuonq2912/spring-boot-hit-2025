package org.example.btvnbuoi5.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi5.base.RestApiV1;
import org.example.btvnbuoi5.base.VsResponseUtil;
import org.example.btvnbuoi5.constant.UrlConstant;
import org.example.btvnbuoi5.domain.dto.EmployeeCreateDto;
import org.example.btvnbuoi5.domain.dto.EmployeeUpdateDto;
import org.example.btvnbuoi5.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestApiV1
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping(UrlConstant.Employee.GET_EMPLOYEES)
    public ResponseEntity<?> getEmployees() {
        return VsResponseUtil.ok(employeeService.getAllEmployee());
    }

    @GetMapping(UrlConstant.Employee.GET_EMPLOYEE)
    public ResponseEntity<?> getEmployeeById(@PathVariable Long employeeId) {
        return VsResponseUtil.ok(employeeService.getEmployeeById(employeeId));
    }

    @GetMapping(UrlConstant.Employee.GET_EMPLOYEES_BY_FULL_NAME)
    public ResponseEntity<?> getEmployeesByFullName(@PathVariable String fullName) {
        return VsResponseUtil.ok(employeeService.getEmployeesByFullName(fullName));
    }

    @GetMapping(UrlConstant.Employee.GET_EMPLOYEES_BY_DEPARTMENT)
    public ResponseEntity<?> getEmployeesByDepartment(@PathVariable Long departmentId) {
        return VsResponseUtil.ok(employeeService.getEmployeesByDepartmentId(departmentId));
    }

    @GetMapping(UrlConstant.Employee.GET_EMPLOYEES_BY_POSITION)
    public ResponseEntity<?> getEmployeesByPosition(@PathVariable Long positionId) {
        return VsResponseUtil.ok(employeeService.getEmployeesByPositionId(positionId));
    }

    @GetMapping(UrlConstant.Employee.GET_EMPLOYEES + "/search")
    public ResponseEntity<?> getEmployeesByMultipleCondition(
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) Long departmentId,
            @RequestParam(required = false) Long positionId) {
        return VsResponseUtil.ok(employeeService.getEmployeeByMultipleCondition(fullName, departmentId, positionId));
    }

    @PostMapping(UrlConstant.Employee.CREATE_EMPLOYEE)
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeCreateDto employeeCreateDto) {
        return VsResponseUtil.ok(employeeService.createEmployee(employeeCreateDto));
    }

    @PutMapping(UrlConstant.Employee.UPDATE_EMPLOYEE)
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody EmployeeUpdateDto employeeUpdateDto, @PathVariable Long employeeId) {
        return VsResponseUtil.ok(employeeService.updateEmployee(employeeId, employeeUpdateDto));
    }

    @DeleteMapping(UrlConstant.Employee.DELETE_EMPLOYEE)
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        return VsResponseUtil.ok(employeeService.deleteEmployee(employeeId));
    }
}