package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CountryDetailDto {

    private Long id;
    private String name;
    private List<StateDto> states;

    public CountryDetailDto(Long id, String name, List<StateDto> states) {
        this.id = id;
        this.name = name;
        this.states = states;
    }

    public CountryDetailDto(Country country) {
        this.id = country.getId();
        this.name = country.getName();
        this.states = new ArrayList<>();
        this.states.addAll(country.getStates().stream().map(StateDto::new).collect(Collectors.toList()));
    }

    public CountryDetailDto() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<StateDto> getStates() {
        return states;
    }
}
