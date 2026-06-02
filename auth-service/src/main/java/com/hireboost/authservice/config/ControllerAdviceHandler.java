package com.hireboost.authservice.config;

import com.hireboost.authservice.model.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
