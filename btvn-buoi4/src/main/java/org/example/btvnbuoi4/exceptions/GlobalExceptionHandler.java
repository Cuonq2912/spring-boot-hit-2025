package org.example.btvnbuoi4.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.example.btvnbuoi4.dtos.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : ex.getBindingResult().getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            return ErrorResponse.builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("Validation failed")
                    .error(errors.toString())
                    .path(request.getRequestURI())
                    .dateTime(new Date())
                    .build();
        }

        @ExceptionHandler(RuntimeException.class)
        ErrorResponse handlingRuntimeException(RuntimeException exception, HttpServletRequest request){
            return ErrorResponse.builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("")
                    .error(exception.getMessage())
                    .path(request.getRequestURI())
                    .dateTime(new Date())
                    .build();
        }


}
