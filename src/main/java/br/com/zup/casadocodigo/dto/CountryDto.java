package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.controller.request.CountryRequestDto;
import br.com.zup.casadocodigo.model.Country;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

public class CountryDto {

    private Long id;
    private String name;

    public CountryDto(String name) {
        this.name = name;
    }

    public CountryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CountryDto(Country country) {
        this.id = country.getId();
        this.name = country.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static List<CountryDto> toCountryDto(List<Country> countries) {
        return countries.stream().map(CountryDto::new).collect(Collectors.toList());
    }
}
