package br.com.zup.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    public void testToString() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Category category = new Category();

        // Act and Assert
        assertEquals(
                "Book[Id: 'null', Título: 'Dr', Resumo: 'Abstract Text', Sumário: 'Summary', Preço: '42', Páginas: '1',"
                        + " ISBN: 'Isbn', Publicação: '1970-01-02', Categoria: 'null', Autor: 'null']",
                (new Book("Dr", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, category, new Author()))
                        .toString());
    }

    @Test
    public void testHashCode() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Category category = new Category();

        // Act and Assert
        assertEquals(-1157361471,
                (new Book("Dr", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, category, new Author()))
                        .hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Category category = new Category("Name");

        // Act and Assert
        assertEquals(-1082329226,
                (new Book("Dr", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, category, new Author()))
                        .hashCode());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertNotEquals((new Book()), "obj");
        assertNotEquals((new Book()), 0);
    }

    @Test
    public void testEquals10() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Author author = new Author("Name", "jane.doe@example.org", "The characteristics of someone or something");
        Book book = new Book("Dr", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, new Category(), author);
        BigDecimal price1 = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt1 = LocalDate.ofEpochDay(1L);
        Category category = new Category();

        // Act and Assert
        assertNotEquals(new Book("Dr", "Abstract Text", "Summary", price1, 1, "Isbn", toBePublishedAt1, category, new Author()), book);
    }

    @Test
    public void testEquals11() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(10.0);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Book book = new Book("Dr", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, new Category(), null);
        BigDecimal price1 = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt1 = LocalDate.ofEpochDay(1L);
        Category category = new Category();

        // Act and Assert
        assertNotEquals(new Book("Dr", "Abstract Text", "Summary", price1, 1, "Isbn", toBePublishedAt1, category, new Author()), book);
    }

    @Test
    public void testEquals12() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Book book = new Book("Dr", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, new Category(), null);

        // Act and Assert
        assertNotEquals(new Book(), book);
    }

    @Test
    public void testEquals2() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Category category = new Category();
        Book obj = new Book("Dr", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, category, new Author());

        // Act and Assert
        assertNotEquals(obj, (new Book()));
    }

    @Test
    public void testEquals3() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Category category = new Category();
        Book book = new Book("Dr", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, category, new Author());
        BigDecimal price1 = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt1 = LocalDate.ofEpochDay(1L);
        Category category1 = new Category();

        // Act and Assert
        assertEquals(new Book("Dr", "Abstract Text", "Summary", price1, 1, "Isbn", toBePublishedAt1, category1, new Author()), book);
    }

    @Test
    public void testEquals4() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Category category = new Category();
        Book book = new Book("Dr", "]", "Summary", price, 1, "Isbn", toBePublishedAt, category, new Author());
        BigDecimal price1 = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt1 = LocalDate.ofEpochDay(1L);
        Category category1 = new Category();

        // Act and Assert
        assertNotEquals(new Book("Dr", "Abstract Text", "Summary", price1, 1, "Isbn", toBePublishedAt1, category1, new Author()), book);
    }

    @Test
    public void testEquals5() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Category category = new Category();
        Book book = new Book("Dr", "Abstract Text", "]", price, 1, "Isbn", toBePublishedAt, category, new Author());
        BigDecimal price1 = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt1 = LocalDate.ofEpochDay(1L);
        Category category1 = new Category();

        // Act and Assert
        assertNotEquals(new Book("Dr", "Abstract Text", "Summary", price1, 1, "Isbn", toBePublishedAt1, category1, new Author()), book);
    }

    @Test
    public void testEquals6() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(0L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Category category = new Category();
        Book book = new Book("Dr", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, category, new Author());
        BigDecimal price1 = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt1 = LocalDate.ofEpochDay(1L);
        Category category1 = new Category();

        // Act and Assert
        assertNotEquals(new Book("Dr", "Abstract Text", "Summary", price1, 1, "Isbn", toBePublishedAt1, category1, new Author()), book);
    }

    @Test
    public void testEquals7() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Category category = new Category();
        Book book = new Book("Dr", "Abstract Text", "Summary", price, 1, "]", toBePublishedAt, category, new Author());
        BigDecimal price1 = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt1 = LocalDate.ofEpochDay(1L);
        Category category1 = new Category();

        // Act and Assert
        assertNotEquals(new Book("Dr", "Abstract Text", "Summary", price1, 1, "Isbn", toBePublishedAt1, category1, new Author()), book);
    }

    @Test
    public void testEquals8() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(0L);
        Category category = new Category();
        Book book = new Book("Dr", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, category, new Author());
        BigDecimal price1 = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt1 = LocalDate.ofEpochDay(1L);
        Category category1 = new Category();

        // Act and Assert
        assertNotEquals(new Book("Dr", "Abstract Text", "Summary", price1, 1, "Isbn", toBePublishedAt1, category1, new Author()), book);
    }

    @Test
    public void testEquals9() {
        // Arrange
        BigDecimal price = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt = LocalDate.ofEpochDay(1L);
        Category category = new Category("Name");
        Book book = new Book("Dr", "Abstract Text", "Summary", price, 1, "Isbn", toBePublishedAt, category, new Author());
        BigDecimal price1 = BigDecimal.valueOf(42L);
        LocalDate toBePublishedAt1 = LocalDate.ofEpochDay(1L);
        Category category1 = new Category();

        // Act and Assert
        assertNotEquals(new Book("Dr", "Abstract Text", "Summary", price1, 1, "Isbn", toBePublishedAt1, category1, new Author()), book);
    }
}

