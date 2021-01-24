package br.com.zup.casadocodigo.controller.request;

import br.com.zup.casadocodigo.exception.StateConversionException;
import br.com.zup.casadocodigo.model.*;
import br.com.zup.casadocodigo.repository.CountryRepository;
import br.com.zup.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;
import java.util.NoSuchElementException;
import java.util.Optional;

public class StateRequestDto {

    private Long id;

    @NotBlank(message = "Nome do estado é obrigatório.")
    @UniqueValue(domainClass = State.class, fieldName = "name", message = "Estado já cadastrado.")
    private String name;

    @NotBlank(message = "Nome do país é obrigatório.")
    private String countryName;

    public StateRequestDto() {
    }

    public StateRequestDto(Long id, @NotBlank(message = "Nome do estado é obrigatório.") String name, String countryName) {
        this.id = id;
        this.name = name;
        this.countryName = countryName;
    }

    public StateRequestDto(@NotBlank(message = "Nome do estado é obrigatório.") String name, String countryName) {
        this.name = name;
        this.countryName = countryName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryName() {
        return countryName;
    }

    public State convertStateRequestToState(CountryRepository countryRepository) throws NoSuchElementException,
            StateConversionException {

        Optional<Country> country = countryRepository.findCountryByName(countryName);

        if (country.isPresent()) {
            return new State(name, country.get());
        }
        else {
            throw new StateConversionException(country);
        }
    }
}
