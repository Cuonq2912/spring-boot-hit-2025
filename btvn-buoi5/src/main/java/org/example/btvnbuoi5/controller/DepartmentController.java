package org.example.btvnbuoi5.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi5.base.RestApiV1;
import org.example.btvnbuoi5.base.VsResponseUtil;
import org.example.btvnbuoi5.constant.UrlConstant;
import org.example.btvnbuoi5.domain.dto.DepartmentCreateDto;
import org.example.btvnbuoi5.domain.dto.DepartmentUpdateDto;
import org.example.btvnbuoi5.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestApiV1
public class DepartmentController {

    DepartmentService departmentService;

    @GetMapping(UrlConstant.Department.GET_DEPARTMENTS)
    public ResponseEntity<?> getDepartments(){
        return VsResponseUtil.ok(departmentService.getAllDepartment());
    }

    @GetMapping(UrlConstant.Department.GET_DEPARTMENT)
    public ResponseEntity<?> getDepartmentById(@PathVariable Long departmentId) {
        return VsResponseUtil.ok(departmentService.getDepartmentById(departmentId));
    }

    @PostMapping(UrlConstant.Department.CREATE_DEPARTMENT)
    public ResponseEntity<?> createDepartment(@Valid @RequestBody DepartmentCreateDto departmentCreateDto) {
        return VsResponseUtil.ok(departmentService.createDepartment(departmentCreateDto));
    }

    @PutMapping(UrlConstant.Department.UPDATE_DEPARTMENT)
    public ResponseEntity<?> updateDepartment(@Valid @RequestBody DepartmentUpdateDto departmentUpdateDto, @PathVariable Long departmentId) {
        return VsResponseUtil.ok(departmentService.updateDepartment(departmentId, departmentUpdateDto));
    }

    @DeleteMapping(UrlConstant.Department.DELETE_DEPARTMENT)
    public ResponseEntity<?> deleteDepartment(@PathVariable Long departmentId) {
        return VsResponseUtil.ok(departmentService.deleteDepartment(departmentId));
    }

}
