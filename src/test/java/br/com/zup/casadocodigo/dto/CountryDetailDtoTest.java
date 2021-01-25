package br.com.zup.casadocodigo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.zup.casadocodigo.model.Country;
import org.junit.jupiter.api.Test;

public class CountryDetailDtoTest {
    @Test
    public void testConstructor() {
        // Arrange and Act
        CountryDetailDto actualCountryDetailDto = new CountryDetailDto(new Country());

        // Assert
        assertNull(actualCountryDetailDto.getName());
        assertNull(actualCountryDetailDto.getId());
        assertTrue(actualCountryDetailDto.getStates().isEmpty());
    }

    @Test
    public void testConstructor2() {
        // Arrange and Act
        CountryDetailDto actualCountryDetailDto = new CountryDetailDto(
                new Country("br.com.zup.casadocodigo.model.Country"));

        // Assert
        assertEquals("br.com.zup.casadocodigo.model.Country", actualCountryDetailDto.getName());
        assertNull(actualCountryDetailDto.getId());
        assertTrue(actualCountryDetailDto.getStates().isEmpty());
    }
}

