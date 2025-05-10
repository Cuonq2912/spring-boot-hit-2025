package org.example.btvnbuoi5.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeUpdateDto {

     Long departmentId;
     Long positionId;
     Long userId;
     String fullName;
     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
     LocalDate dateOfBirth;
     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
     LocalDate hiredDate;
     BigDecimal salary;
}