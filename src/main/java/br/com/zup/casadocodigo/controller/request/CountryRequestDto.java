package br.com.zup.casadocodigo.controller.request;

import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CountryRequestDto {

    private Long id;
    @NotBlank(message = "Nome do país é obrigatório.")
    @UniqueValue(domainClass = Country.class, fieldName = "name", message = "País já cadastrado.")
    private String name;

    public CountryRequestDto(Long id, @NotBlank(message = "Nome do país é obrigatório.") String name) {
        this.id = id;
        this.name = name;
    }

    public CountryRequestDto(Country country) {
        this.id = country.getId();
        this.name = country.getName();
    }

    public CountryRequestDto() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country toCountry() {
        return new Country(name);
    }
}
