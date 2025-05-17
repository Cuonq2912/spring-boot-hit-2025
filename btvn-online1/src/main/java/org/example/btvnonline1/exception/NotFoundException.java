package org.example.btvnonline1.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message, Long id) {
        super(message);
    }
}
