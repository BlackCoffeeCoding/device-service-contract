package org.blackcoffeecoding.device.api.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import java.util.Objects;

// @Relation задает имена полей в JSON: "company" для одного, "companies" для списка
@Relation(collectionRelation = "companies", itemRelation = "company")
public class CompanyResponse extends RepresentationModel<CompanyResponse> {
    private Long id;
    private String name;
    private String abbreviation;

    // Пустой конструктор нужен для сериализации
    public CompanyResponse() {}

    public CompanyResponse(Long id, String name, String abbreviation) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getAbbreviation() { return abbreviation; }

    // Важно для корректной работы HATEOAS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompanyResponse that = (CompanyResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name);
    }
}