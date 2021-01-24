package br.com.zup.casadocodigo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.zup.casadocodigo.model.Category;
import org.junit.jupiter.api.Test;

public class CategoryDtoTest {
    @Test
    public void testConstructor() {
        // Arrange, Act and Assert
        assertNull((new CategoryDto(new Category())).getName());
    }

    @Test
    public void testConstructor2() {
        // Arrange
        Category category = new Category();
        category.setName("Name");

        // Act and Assert
        assertEquals("Name", (new CategoryDto(category)).getName());
    }

    @Test
    public void testSetName() {
        // Arrange
        CategoryDto categoryDto = new CategoryDto();

        // Act
        categoryDto.setName("Name");

        // Assert
        assertEquals("Name", categoryDto.getName());
    }

    @Test
    public void testToCategory() {
        // Arrange, Act and Assert
        assertNull((new CategoryDto()).toCategory().getName());
    }
}

