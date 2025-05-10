package org.example.btvnbuoi5.service.work;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi5.constant.CommonConstant;
import org.example.btvnbuoi5.constant.CommonMessage;
import org.example.btvnbuoi5.constant.ErrorMessage;
import org.example.btvnbuoi5.domain.dto.DepartmentCreateDto;
import org.example.btvnbuoi5.domain.dto.DepartmentDto;
import org.example.btvnbuoi5.domain.dto.DepartmentUpdateDto;
import org.example.btvnbuoi5.domain.dto.response.CommonResponseDto;
import org.example.btvnbuoi5.domain.entity.Department;
import org.example.btvnbuoi5.domain.mapper.DepartmentMapper;
import org.example.btvnbuoi5.exception.NotFoundException;
import org.example.btvnbuoi5.repository.DepartmentRepository;
import org.example.btvnbuoi5.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentWork implements DepartmentService {

    DepartmentRepository departmentRepository;
    DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentDto> getAllDepartment() {
        return departmentRepository.findAll().stream()
                .map(departmentMapper::toDepartmentDto)
                .toList();
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        checkDepartmentNotFound(department, id);
        return departmentMapper.toDepartmentDto(department.get());
    }

    @Override
    public DepartmentDto createDepartment(DepartmentCreateDto departmentDto) {
        Department department = departmentMapper.toDepartment(departmentDto);
        return departmentMapper.toDepartmentDto(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentUpdateDto departmentDto) {
        Optional<Department> department = departmentRepository.findById(id);
        checkDepartmentNotFound(department, id);
        departmentMapper.updateDepartmentFromDto(departmentDto, department.get());
        return departmentMapper.toDepartmentDto(departmentRepository.save(department.get()));
    }

    @Override
    public CommonResponseDto deleteDepartment(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        checkDepartmentNotFound(department, id);
        departmentRepository.deleteById(id);
        return new CommonResponseDto(CommonConstant.TRUE, CommonMessage.DELETE_SUCCESS);
    }

    private void checkDepartmentNotFound(Optional<Department> department, Long id){
        if(department.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.Department.ERR_NOT_FOUND_ID, id));
        }
    }
}
