package com.hireboost.coreservice.job_application.dto;

import com.hireboost.coreservice.enums.EAppStatus;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public record JobApplicationMinimalDTO(
        UUID id,
        @NotNull UUID userId,
        @NotNull UUID jobId,
        @NotNull String company,
        @NotNull String position,
        @NotNull EAppStatus applicationStatus,
        Instant appliedAt
) {
}
