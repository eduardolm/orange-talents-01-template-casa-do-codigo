package br.com.zup.casadocodigo.exception;

import br.com.zup.casadocodigo.exception.dto.FieldErrorOutputDto;
import br.com.zup.casadocodigo.model.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StateConversionException extends Throwable {

    private Optional<Country> country;
    private List<FieldErrorOutputDto> errors = new ArrayList<>();

    public StateConversionException(Optional<Country> country) {
        this.country = country;
        if (country.isEmpty()) errors.add(new FieldErrorOutputDto("country", "País não encontrado."));
    }

    public Optional<Country> getCountry() {
        return country;
    }

    public List<FieldErrorOutputDto> getErrors() {
        return errors;
    }
}
