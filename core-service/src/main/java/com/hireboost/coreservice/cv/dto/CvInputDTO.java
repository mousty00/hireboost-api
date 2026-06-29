package com.hireboost.coreservice.cv.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Map;

public record CvInputDTO(
        @NotNull String title,
        String summary,
        List<String> skills,
        Map<String, Object> languages,
        Map<String, Object> experience,
        Map<String, Object> education,
        Map<String, Object> certification,
        String fileUrl
) {
}
