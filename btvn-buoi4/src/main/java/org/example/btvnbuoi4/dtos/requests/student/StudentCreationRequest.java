package org.example.btvnbuoi4.dtos.requests.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi4.models.Classes;
import org.example.btvnbuoi4.models.Gender;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentCreationRequest {
    @Size(min = 10, max = 50, message = "STUDENT_NAME_INVALID")
    @NotNull(message = "NOT_NULL_INPUT")
    String name;

    @NotNull(message = "NOT_NULL_INPUT")
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date dateOfBirth;

    @NotNull(message = "NOT_NULL_INPUT")
    Gender gender;

    @NotNull(message = "NOT_NULL_INPUT")
    @Email(message = "INVALID_EMAIL")
    String email;

    @NotNull(message = "NOT_NULL_INPUT")
    @Pattern(regexp = "^\\d{10}$", message = "INVALID_PHONE_NUMBER")
    String phoneNumber;

    @NotNull(message = "NOT_NULL_INPUT")
    Long classId;
}
