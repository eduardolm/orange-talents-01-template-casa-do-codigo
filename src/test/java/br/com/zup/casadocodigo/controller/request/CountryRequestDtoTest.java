package br.com.zup.casadocodigo.controller.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.zup.casadocodigo.model.Country;
import org.junit.jupiter.api.Test;

public class CountryRequestDtoTest {
    @Test
    public void testConstructor() {
        // Arrange and Act
        CountryRequestDto actualCountryRequestDto = new CountryRequestDto(new Country());

        // Assert
        assertNull(actualCountryRequestDto.getName());
        assertNull(actualCountryRequestDto.getId());
    }

    @Test
    public void testConstructor2() {
        // Arrange and Act
        CountryRequestDto actualCountryRequestDto = new CountryRequestDto(
                new Country("br.com.zup.casadocodigo.model.Country"));

        // Assert
        assertEquals("br.com.zup.casadocodigo.model.Country", actualCountryRequestDto.getName());
        assertNull(actualCountryRequestDto.getId());
    }

    @Test
    public void testToCountry() {
        // Arrange, Act and Assert
        assertNull((new CountryRequestDto()).toCountry().getName());
    }
}

