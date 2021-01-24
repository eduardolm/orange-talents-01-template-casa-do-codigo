package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.State;
import br.com.zup.casadocodigo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StateDetailDto {

    @Autowired
    private CountryRepository countryRepository;

    private Long id;
    private String name;
    private String country;

    public StateDetailDto(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public StateDetailDto(State state) {
        this.id = state.getId();
        this.name = state.getName();
        this.country = state.getCountry().getName();
    }

    public StateDetailDto() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
