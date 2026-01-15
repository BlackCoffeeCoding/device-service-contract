package org.blackcoffeecoding.device.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CompanyRequest(
        @NotBlank(message = "Название компании обязательно")
        String name,

        @NotBlank(message = "Аббревиатура обязательна")
        String abbreviation
) {}