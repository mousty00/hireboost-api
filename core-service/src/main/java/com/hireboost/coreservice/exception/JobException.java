package com.hireboost.coreservice.exception;

import org.springframework.http.HttpStatus;

public class JobException extends RuntimeException {
    private HttpStatus status;

    public JobException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public static JobException notFound() {
        return new JobException("job not found", HttpStatus.NOT_FOUND);
    }
}
