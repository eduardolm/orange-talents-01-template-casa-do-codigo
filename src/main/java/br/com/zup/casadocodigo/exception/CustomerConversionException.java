package br.com.zup.casadocodigo.exception;

import br.com.zup.casadocodigo.exception.dto.FieldErrorOutputDto;
import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.model.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerConversionException extends Throwable {

    private Optional<Country> country;
    private Optional<State> state;
    private List<FieldErrorOutputDto> errors = new ArrayList<>();

    public CustomerConversionException(Optional<Country> country, Optional<State> state) {
        this.country = country;
        this.state = state;
        if (country.isEmpty()) errors.add(new FieldErrorOutputDto("country", "País não encontrado."));
        if (state.isEmpty()) errors.add(new FieldErrorOutputDto("state", "Estado não encontrado."));
    }

    public Optional<Country> getCountry() {
        return country;
    }

    public Optional<State> getState() {
        return state;
    }

    public List<FieldErrorOutputDto> getErrors() {
        return errors;
    }
}
