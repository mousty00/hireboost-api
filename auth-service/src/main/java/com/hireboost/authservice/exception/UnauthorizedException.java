package com.hireboost.authservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class UnauthorizedException extends RuntimeException {
    private HttpStatus status;

    public UnauthorizedException(String message) {
        super(message);
        this.status = HttpStatus.FORBIDDEN;
    }
}
