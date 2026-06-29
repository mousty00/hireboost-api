package com.hireboost.coreservice.model;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Builder
public record ResponseBody(
        Boolean success,
        String message,
        Instant timestamp,
        HttpStatus status
) {
    public static ResponseBodyBuilder builder() {
        return new ResponseBodyBuilder()
                .success(false)
                .timestamp(Instant.now());
    }
}
