package com.hireboost.authservice.user.dto;

import jakarta.validation.constraints.NotBlank;

public record RoleDTO(
        @NotBlank
        Integer id,

        @NotBlank
        String name
) {
}
