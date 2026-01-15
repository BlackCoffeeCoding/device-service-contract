package org.blackcoffeecoding.device.api.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import java.time.LocalDate;
import java.util.Objects;

@Relation(collectionRelation = "devices", itemRelation = "device")
public class DeviceResponse extends RepresentationModel<DeviceResponse> {
    private Long id;
    private String name;
    private String serialNumber;
    private String category; // Новое поле
    private LocalDate releaseDate;
    private CompanyResponse company;

    public DeviceResponse() {}

    public DeviceResponse(Long id, String name, String serialNumber, String category, LocalDate releaseDate, CompanyResponse company) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.category = category;
        this.releaseDate = releaseDate;
        this.company = company;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSerialNumber() { return serialNumber; }
    public String getCategory() { return category; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public CompanyResponse getCompany() { return company; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeviceResponse that = (DeviceResponse) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, serialNumber, category);
    }
}