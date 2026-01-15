package org.blackcoffeecoding.device.api.endpoints;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.blackcoffeecoding.device.api.dto.DeviceRequest;
import org.blackcoffeecoding.device.api.dto.DeviceResponse;
import org.blackcoffeecoding.device.api.dto.StatusResponse;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "devices", description = "API для работы с устройствами")
@RequestMapping("/api/devices")
public interface DeviceApi {

    @Operation(summary = "Получить устройство по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Устройство найдено",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DeviceResponse.class))),
            @ApiResponse(responseCode = "404", description = "Устройство не найдено",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class)))
    })
    @GetMapping("/{id}")
        // БЫЛО: DeviceResponse getDevice(...)
        // СТАЛО: Добавили EntityModel<...>, чтобы совпадало с контроллером
    EntityModel<DeviceResponse> getDevice(@PathVariable("id") Long id);

    @Operation(summary = "Создать новое устройство")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Устройство успешно создано",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DeviceResponse.class))),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации данных",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class)))
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
        // Тут оставляем DeviceResponse, так как в контроллере ты пока не используешь ассемблер для создания
    DeviceResponse createDevice(@Valid @RequestBody DeviceRequest request);

    @Operation(summary = "Получить все устройства (с пагинацией)")
    @GetMapping
    PagedModel<EntityModel<DeviceResponse>> getAllDevices(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );
}