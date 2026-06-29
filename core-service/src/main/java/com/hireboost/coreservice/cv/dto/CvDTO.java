package com.hireboost.coreservice.cv.dto;

import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public record CvDTO(
        UUID id,
        @NotNull UUID userId,
        @NotNull String title,
        String summary,
        List<String> skills,
        Map<String, Object> languages,
        Map<String, Object> experience,
        Map<String, Object> education,
        Map<String, Object> certification,
        String fileUrl,
        Boolean isActive,
        Instant createdAt,
        Instant updatedAt
) {
}
