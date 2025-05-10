package org.example.btvnbuoi5.domain.dto;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi5.domain.entity.Department;
import org.example.btvnbuoi5.domain.entity.Position;
import org.example.btvnbuoi5.domain.entity.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {

    Long id;
    Long departmentId;
    Long positionId;
    Long userId;
    String fullName;
    LocalDate dateOfBirth;
    LocalDate hiredDate;
    BigDecimal salary;

}
