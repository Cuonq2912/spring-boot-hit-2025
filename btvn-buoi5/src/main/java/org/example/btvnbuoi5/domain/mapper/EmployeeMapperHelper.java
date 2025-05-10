package org.example.btvnbuoi5.domain.mapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi5.domain.entity.Department;
import org.example.btvnbuoi5.domain.entity.Position;
import org.example.btvnbuoi5.domain.entity.User;
import org.example.btvnbuoi5.repository.DepartmentRepository;
import org.example.btvnbuoi5.repository.PositionRepository;
import org.example.btvnbuoi5.repository.UserRepository;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeMapperHelper {

    DepartmentRepository departmentRepository;
    PositionRepository positionRepository;
    UserRepository userRepository;

    @Named("mapDepartment")
    public Department mapDepartment(Long id) {
        return id == null ? null : departmentRepository.findById(id).orElse(null);
    }

    @Named("mapPosition")
    public Position mapPosition(Long id) {
        return id == null ? null : positionRepository.findById(id).orElse(null);
    }

    @Named("mapUser")
    public User mapUser(Long id) {
        return id == null ? null : userRepository.findById(id).orElse(null);
    }
}