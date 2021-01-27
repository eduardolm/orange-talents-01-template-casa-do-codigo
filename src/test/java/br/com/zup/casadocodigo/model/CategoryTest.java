package br.com.zup.casadocodigo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {
    @Test
    public void testSetName() {
        // Arrange
        Category category = new Category();

        // Act
        category.setName("Name");

        // Assert
        assertEquals("Name", category.getName());
    }

    @Test
    public void testToCategoryDto() {
        // Arrange, Act and Assert
        assertNull((new Category()).toCategoryDto().getName());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(961, (new Category()).hashCode());
        assertEquals(2421356, (new Category("Name")).hashCode());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertNotEquals((new Category()), "obj");
    }

    @Test
    public void testEquals2() {
        // Arrange
        Category category = new Category();
        category.setName("Name");

        // Act and Assert
        assertNotEquals(category, (new Category()));
    }

    @Test
    public void testEquals3() {
        // Arrange
        Category category = new Category("Name");
        Category category1 = new Category();
        category1.setName("Name");

        // Act and Assert
        assertEquals(category1, category);
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("Categoria [Id: null, Nome: null]", (new Category()).toString());
    }
}

