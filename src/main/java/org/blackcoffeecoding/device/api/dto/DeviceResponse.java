package org.blackcoffeecoding.device.api.dto;

import java.time.LocalDate;

public record DeviceResponse(
        Long id,
        String name,
        String serialNumber,
        LocalDate releaseDate,
        CompanyResponse company // Вкладываем полную информацию о компании
) {}