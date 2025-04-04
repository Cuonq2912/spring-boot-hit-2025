package org.example.btvnbuoi4.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.example.btvnbuoi4.dtos.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
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
