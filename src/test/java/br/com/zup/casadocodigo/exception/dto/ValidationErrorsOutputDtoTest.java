package br.com.zup.casadocodigo.exception.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ValidationErrorsOutputDtoTest {
    @Test
    public void testAddError() {
        // Arrange
        ValidationErrorsOutputDto validationErrorsOutputDto = new ValidationErrorsOutputDto();

        // Act
        validationErrorsOutputDto.addError("Not all who wander are lost");

        // Assert
        List<String> globalErrorMessages = validationErrorsOutputDto.getGlobalErrorMessages();
        assertEquals(1, globalErrorMessages.size());
        assertEquals("Not all who wander are lost", globalErrorMessages.get(0));
    }

    @Test
    public void testAddFieldError() {
        // Arrange
        ValidationErrorsOutputDto validationErrorsOutputDto = new ValidationErrorsOutputDto();

        // Act
        validationErrorsOutputDto.addFieldError("Field", "Not all who wander are lost");

        // Assert
        List<FieldErrorOutputDto> errors = validationErrorsOutputDto.getErrors();
        assertEquals(1, errors.size());
        FieldErrorOutputDto getResult = errors.get(0);
        assertEquals("Field", getResult.getField());
        assertEquals("Not all who wander are lost", getResult.getMessage());
    }
}

