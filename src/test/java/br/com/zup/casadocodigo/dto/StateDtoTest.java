package br.com.zup.casadocodigo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.model.State;
import org.junit.jupiter.api.Test;

public class StateDtoTest {
    @Test
    public void testConstructor() {
        // Arrange and Act
        StateDto actualStateDto = new StateDto(new State());

        // Assert
        assertNull(actualStateDto.getName());
        assertNull(actualStateDto.getId());
    }

    @Test
    public void testConstructor2() {
        // Arrange and Act
        StateDto actualStateDto = new StateDto(new State("br.com.zup.casadocodigo.model.State", new Country()));

        // Assert
        assertEquals("br.com.zup.casadocodigo.model.State", actualStateDto.getName());
        assertNull(actualStateDto.getId());
    }
}

