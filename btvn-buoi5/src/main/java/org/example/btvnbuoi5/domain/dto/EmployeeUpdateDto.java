package org.example.btvnbuoi5.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeUpdateDto {

    private Long departmentId;
    private Long positionId;
    private Long userId;
    private String fullname;
    private BigDecimal salary;
}