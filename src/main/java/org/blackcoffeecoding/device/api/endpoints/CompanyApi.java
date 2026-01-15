package org.blackcoffeecoding.device.api.endpoints;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.blackcoffeecoding.device.api.dto.CompanyRequest;
import org.blackcoffeecoding.device.api.dto.CompanyResponse;
import org.blackcoffeecoding.device.api.dto.StatusResponse;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "companies", description = "API для работы с компаниями")
@RequestMapping("/api/companies")
public interface CompanyApi {

    @Operation(summary = "Получить компанию по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Компания найдена",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompanyResponse.class))),
            @ApiResponse(responseCode = "404", description = "Компания не найдена",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class)))
    })
    @GetMapping("/{id}")
    EntityModel<CompanyResponse> getCompany(@PathVariable("id") Long id);

    @Operation(summary = "Получить все компании (с пагинацией)")
    @ApiResponse(responseCode = "200", description = "Список компаний получен")
    @GetMapping
    PagedModel<EntityModel<CompanyResponse>> getAllCompanies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );

    @Operation(summary = "Создать новую компанию")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Компания успешно создана",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompanyResponse.class))),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации данных",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class))),
            @ApiResponse(responseCode = "409", description = "Компания с таким названием уже существует",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class)))
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CompanyResponse createCompany(@Valid @RequestBody CompanyRequest request);
}