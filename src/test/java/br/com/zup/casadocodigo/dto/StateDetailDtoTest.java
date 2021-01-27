package br.com.zup.casadocodigo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.model.State;
import org.junit.jupiter.api.Test;

public class StateDetailDtoTest {
    @Test
    public void testConstructor() {
        // Arrange and Act
        StateDetailDto actualStateDetailDto = new StateDetailDto(new State("Name", new Country()));

        // Assert
        assertNull(actualStateDetailDto.getCountry());
        assertNull(actualStateDetailDto.getId());
        assertEquals("Name", actualStateDetailDto.getName());
    }

    @Test
    public void testConstructor2() {
        // Arrange and Act
        StateDetailDto actualStateDetailDto = new StateDetailDto(
                new State("br.com.zup.casadocodigo.model.State", new Country()));

        // Assert
        assertNull(actualStateDetailDto.getCountry());
        assertNull(actualStateDetailDto.getId());
        assertEquals("br.com.zup.casadocodigo.model.State", actualStateDetailDto.getName());
    }
}

