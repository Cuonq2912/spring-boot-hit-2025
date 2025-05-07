package org.example.btvnbuoi5.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.btvnbuoi5.constant.ErrorMessage;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateDto {

    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    private String username;

    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$", message = ErrorMessage.INVALID_FORMAT_PASSWORD)
    private String password;

    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    @Email(message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String email;
}