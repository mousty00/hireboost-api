package com.hireboost.coreservice.cv.dto;

import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record CvMinimalDTO(
        UUID id,
        @NotNull UUID userId,
        @NotNull String title,
        List<String> skills,
        Boolean isActive,
        Instant createdAt
) {
}
