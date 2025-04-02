package org.example.btvnbuoi4.dtos.requests.classes;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClassesCreationRequest {
    @Size(min = 10, max = 50, message = "CLASSES_NAME_INVALID")
    @NotNull(message = "NOT_NULL_INPUT")
    String name;
    @NotNull(message = "NOT_NULL_INPUT")
    String subject;
}
