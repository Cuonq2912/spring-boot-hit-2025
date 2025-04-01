package org.example.btvnbuoi4.dtos.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi4.models.Gender;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
    Long id;
    String name;
    Date dateOfBirth;
    Gender gender;
    String email;
    String phoneNumber;

    ClassInfo classes;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class ClassInfo {
        Long id;
        String name;
        String subject;
    }
}
