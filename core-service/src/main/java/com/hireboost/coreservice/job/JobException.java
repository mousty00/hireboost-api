package com.hireboost.coreservice.job;

import org.springframework.http.HttpStatus;

import java.util.UUID;

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
