package com.hireboost.coreservice.auto_apply_log.dto;

import com.hireboost.coreservice.enums.EAutoApplyLogStatus;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public record AutoApplyLogDTO(
        UUID id,
        @NotNull UUID userId,
        @NotNull UUID jobId,
        @NotNull UUID cvId,
        @NotNull Double matchScore,
        @NotNull EAutoApplyLogStatus status,
        String errorMessage,
        Instant triggeredAt
) {
}
