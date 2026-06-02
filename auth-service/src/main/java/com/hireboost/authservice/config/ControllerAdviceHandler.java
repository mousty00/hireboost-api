package com.hireboost.authservice.config;

import com.hireboost.authservice.exception.UnauthorizedException;
import com.hireboost.authservice.model.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ControllerAdviceHandler {

//    TODO Enhance exception handling
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBody handleGenericErrorException(Exception e){
        return ResponseBody.builder()
                .message(e.getLocalizedMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseBody handleUnauthorizedException(UnauthorizedException e) {
        return ResponseBody.builder()
                .message(e.getMessage())
                .status(e.getStatus())
                .build();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseBody handleUserAlreadyExistsException(NullPointerException e) {
        return ResponseBody.builder()
                .message(e.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseBody handleInvalidMethodArgsException(MethodArgumentNotValidException e) {
        List<String> errors = e.getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage())
                .toList();

        return ResponseBody.builder()
                .message(String.join(", ", errors))
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }
}
