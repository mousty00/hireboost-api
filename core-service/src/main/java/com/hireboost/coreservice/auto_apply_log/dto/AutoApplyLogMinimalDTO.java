package com.hireboost.coreservice.auto_apply_log.dto;

import com.hireboost.coreservice.enums.EAutoApplyLogStatus;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public record AutoApplyLogMinimalDTO(
        UUID id,
        @NotNull UUID userId,
        @NotNull Double matchScore,
        @NotNull EAutoApplyLogStatus status,
        Instant triggeredAt
) {
}
