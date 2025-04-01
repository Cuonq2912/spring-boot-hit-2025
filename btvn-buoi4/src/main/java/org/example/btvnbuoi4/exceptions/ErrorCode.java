package org.example.btvnbuoi4.exceptions;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    STUDENT_NAME_INVALID(1002, "Name must be between 10 and 50 characters"),
    STUDENT_NOT_FOUND(1003, "Student Not Found"),
    CLASSES_NAME_INVALID(1012, "Class name must be between 10 and 50 characters"),
    CLASSES_NAME_EXISTS(1013, "Class name already exists"),
    CLASSES_NOT_FOUND(1014, "Class is not found"),
    NOT_NULL_INPUT(1004, "Invalid Input Data: data not null"),
    INTERNAL_SERVER_ERROR(1005, "Internal Server Error"),
    ACCESS_DENIED(1006, "Access Denied"),
    DATABASE_ERROR(1007, "Database Error"),
    INVALID_EMAIL(1008, "Invalid email format"),
    INVALID_PHONE_NUMBER(1009, "Phone number must be exactly 10 digits"),
    EMAIL_ALREADY_EXISTS(1010, "Email already exists"),
    PHONE_NUMBER_ALREADY_EXISTS(1011, "Phone number already exists")
    ;
    int code;
    String message;
}
