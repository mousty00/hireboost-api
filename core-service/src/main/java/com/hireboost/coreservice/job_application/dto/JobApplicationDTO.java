package com.hireboost.coreservice.job_application.dto;

import com.hireboost.coreservice.enums.EAppStatus;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public record JobApplicationDTO(
        UUID id,
        @NotNull UUID userId,
        @NotNull UUID jobId,
        @NotNull UUID cvId,
        @NotNull String company,
        @NotNull String position,
        @NotNull EAppStatus applicationStatus,
        String locationCity,
        String locationCountry,
        Double locationLat,
        Double locationLng,
        String jobUrl,
        String notes,
        Double matchScore,
        Instant appliedAt,
        Instant createdAt,
        Instant updatedAt
) {
}
