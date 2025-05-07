package org.example.btvnbuoi5.domain.dto;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi5.domain.entity.Employee;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentDto {


    Long id;
    String name;
    String description;

}
