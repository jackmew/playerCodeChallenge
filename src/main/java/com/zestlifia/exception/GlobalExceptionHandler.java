package com.zestlifia.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException e) {
        // Check if the required type is available and is an enum
        if (e.getRequiredType() != null && e.getRequiredType().isEnum()) {
            // Handling enum specific type mismatch
            return ResponseEntity.badRequest().body("Invalid value for enum type: " + e.getRequiredType().getSimpleName() + "; value: " + e.getValue());
        } else if (e.getRequiredType() != null) {
            // Generic type mismatch error
            return ResponseEntity.badRequest().body("Parameter conversion error: " + e.getMessage());
        } else {
            // Fallback error message when type information is not available
            return ResponseEntity.badRequest().body("Parameter conversion error, type information is unavailable.");
        }
    }
}
