package com.hireboost.coreservice.job.dto;

import com.hireboost.coreservice.enums.EJobType;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record JobDTO(
        UUID id,
        String externalId,
        @NotNull String title,
        @NotNull String company,
        @NotNull String description,
        List<String> skillsRequired,
        String locationCity,
        String locationCountry,
        String locationLat,
        Double locationLng,
        @NotNull EJobType jobType,
        Integer salaryMin,
        Integer salaryMax,
        String source,
        String jobUrl,
        Instant postedAt
) {
}
