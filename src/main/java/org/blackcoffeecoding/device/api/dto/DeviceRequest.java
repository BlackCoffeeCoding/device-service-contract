package org.blackcoffeecoding.device.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public record DeviceRequest(
        @NotBlank(message = "Название устройства не может быть пустым")
        String name,

        @NotBlank(message = "Серийный номер обязателен")
        String serialNumber,

        // Новое поле
        @NotBlank(message = "Категория обязательна")
        String category,

        @PastOrPresent(message = "Дата выпуска не может быть в будущем")
        LocalDate releaseDate,

        @NotNull(message = "ID компании обязателен")
        Long companyId
) {}