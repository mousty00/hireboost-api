package com.hireboost.coreservice.job.dto;

import com.hireboost.coreservice.enums.EJobType;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public record JobMinimalDTO(
        UUID id,
        @NotNull String title,
        @NotNull String company,
        @NotNull String locationCity,
        String locationCountry,
        @NotNull EJobType jobType,
        Integer salaryMin,
        Integer salaryMax,
        String source,
        Instant postedAt
) {
}
