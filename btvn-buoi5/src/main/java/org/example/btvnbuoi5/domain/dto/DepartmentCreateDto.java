package org.example.btvnbuoi5.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.btvnbuoi5.constant.ErrorMessage;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentCreateDto {

    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    private String name;

    private String description;
}