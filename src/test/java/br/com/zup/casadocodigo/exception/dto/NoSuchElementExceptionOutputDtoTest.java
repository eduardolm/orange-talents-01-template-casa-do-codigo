package br.com.zup.casadocodigo.exception.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class NoSuchElementExceptionOutputDtoTest {
    @Test
    public void testAddError() {
        // Arrange
        NoSuchElementExceptionOutputDto noSuchElementExceptionOutputDto = new NoSuchElementExceptionOutputDto();

        // Act
        noSuchElementExceptionOutputDto.addError("An error occurred");

        // Assert
        List<String> errors = noSuchElementExceptionOutputDto.getErrors();
        assertEquals(1, errors.size());
        assertEquals("An error occurred", errors.get(0));
    }
}

