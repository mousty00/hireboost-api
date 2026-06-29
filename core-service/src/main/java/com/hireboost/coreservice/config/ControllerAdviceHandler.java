package com.hireboost.coreservice.config;

import com.hireboost.coreservice.model.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBody handleGenericException(Exception e) {
        return ResponseBody.builder()
                .message(e.getLocalizedMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseBody handleNullPointerException(NullPointerException e) {
        return ResponseBody.builder()
                .message(e.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseBody handleValidationException(MethodArgumentNotValidException e) {
        List<String> errors = e.getFieldErrors().stream()
                .map(fe -> fe.getField() + " " + fe.getDefaultMessage())
                .toList();
        return ResponseBody.builder()
                .message(String.join(", ", errors))
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }
}
