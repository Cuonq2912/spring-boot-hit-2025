package org.example.btvnbuoi5.domain.dto;

import jakarta.validation.constraints.Email;
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
public class UserUpdateDto {

    private String username;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$", message = ErrorMessage.INVALID_FORMAT_PASSWORD)
    private String password;

    @Email(message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String email;
}