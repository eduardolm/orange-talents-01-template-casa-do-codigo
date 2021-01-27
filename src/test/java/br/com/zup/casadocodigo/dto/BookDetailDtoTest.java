package br.com.zup.casadocodigo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.model.Book;
import br.com.zup.casadocodigo.model.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class BookDetailDtoTest {
    @Test
    public void testConstructor() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Category category = new Category();

        // Act
        BookDetailDto actualBookDetailDto = new BookDetailDto(
                new Book("Dr", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, category, new Author()));

        // Assert
        assertEquals(1, actualBookDetailDto.getPages().intValue());
        String actualToStringResult = actualBookDetailDto.getPrice().toString();
        assertNull(actualBookDetailDto.getId());
        assertNull(actualBookDetailDto.getAuthor());
        assertEquals("Dr", actualBookDetailDto.getTitle());
        assertNull(actualBookDetailDto.getCategory());
        assertEquals("Abstract Text", actualBookDetailDto.getAbstractText());
        assertEquals("Isbn", actualBookDetailDto.getIsbn());
        assertEquals("Summary", actualBookDetailDto.getSummary());
        assertEquals("42", actualToStringResult);
    }

    @Test
    public void testConstructor2() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Category category = new Category();

        // Act
        BookDetailDto actualBookDetailDto = new BookDetailDto(
                new Book("Title", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, category, new Author()));

        // Assert
        assertEquals(1, actualBookDetailDto.getPages().intValue());
        String actualToStringResult = actualBookDetailDto.getPrice().toString();
        assertNull(actualBookDetailDto.getId());
        assertNull(actualBookDetailDto.getAuthor());
        assertEquals("Title", actualBookDetailDto.getTitle());
        assertNull(actualBookDetailDto.getCategory());
        assertEquals("Abstract Text", actualBookDetailDto.getAbstractText());
        assertEquals("Isbn", actualBookDetailDto.getIsbn());
        assertEquals("Summary", actualBookDetailDto.getSummary());
        assertEquals("42", actualToStringResult);
    }
}

