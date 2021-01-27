package br.com.zup.casadocodigo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.model.Book;
import br.com.zup.casadocodigo.model.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class BookDtoTest {
    @Test
    public void testConstructor() {
        // Arrange and Act
        BookDto actualBookDto = new BookDto(new Book());

        // Assert
        assertNull(actualBookDto.getTitle());
        assertNull(actualBookDto.getId());
    }

    @Test
    public void testConstructor2() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Category category = new Category();

        // Act
        BookDto actualBookDto = new BookDto(
                new Book("Title", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, category, new Author()));

        // Assert
        assertEquals("Title", actualBookDto.getTitle());
        assertNull(actualBookDto.getId());
    }
}

