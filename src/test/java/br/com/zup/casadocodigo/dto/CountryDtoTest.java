package br.com.zup.casadocodigo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.zup.casadocodigo.model.Country;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CountryDtoTest {
    @Test
    public void testConstructor() {
        // Arrange and Act
        CountryDto actualCountryDto = new CountryDto(new Country());

        // Assert
        assertNull(actualCountryDto.getName());
        assertNull(actualCountryDto.getId());
    }

    @Test
    public void testConstructor2() {
        // Arrange and Act
        CountryDto actualCountryDto = new CountryDto(new Country("br.com.zup.casadocodigo.model.Country"));

        // Assert
        assertEquals("br.com.zup.casadocodigo.model.Country", actualCountryDto.getName());
        assertNull(actualCountryDto.getId());
    }

    @Test
    public void testToCountryDto() {
        // Arrange, Act and Assert
        assertTrue(CountryDto.toCountryDto(new ArrayList<>()).isEmpty());
    }

    @Test
    public void testToCountryDto2() {
        // Arrange
        ArrayList<Country> countryList = new ArrayList<>();
        countryList.add(new Country());

        // Act
        List<CountryDto> actualToCountryDtoResult = CountryDto.toCountryDto(countryList);

        // Assert
        assertEquals(1, actualToCountryDtoResult.size());
        CountryDto getResult = actualToCountryDtoResult.get(0);
        assertNull(getResult.getName());
        assertNull(getResult.getId());
    }

    @Test
    public void testToCountryDto3() {
        // Arrange
        ArrayList<Country> countryList = new ArrayList<>();
        countryList.add(new Country());
        countryList.add(new Country());

        // Act
        List<CountryDto> actualToCountryDtoResult = CountryDto.toCountryDto(countryList);

        // Assert
        assertEquals(2, actualToCountryDtoResult.size());
        CountryDto getResult = actualToCountryDtoResult.get(0);
        CountryDto getResult1 = actualToCountryDtoResult.get(1);
        Long actualId = getResult.getId();
        assertNull(actualId);
        assertNull(getResult1.getId());
        assertNull(getResult1.getName());
        assertNull(getResult.getName());
    }
}

