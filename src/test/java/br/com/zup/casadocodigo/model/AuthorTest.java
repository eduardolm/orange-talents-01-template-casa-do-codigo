package br.com.zup.casadocodigo.model;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthorTest {
    @Test
    public void testConstructor() {
        // Arrange and Act
        Author actualAuthor = new Author();

        // Assert
        assertNull(actualAuthor.getId());
        assertNull(actualAuthor.getName());
        List<Book> books = actualAuthor.getBooks();
        assertTrue(books instanceof java.util.ArrayList);
        assertNull(actualAuthor.getDescription());
        assertTrue(books.isEmpty());
        assertNull(actualAuthor.getEmail());
    }

    @Test
    public void testConstructor2() {
        // Arrange and Act
        Author actualAuthor = new Author("Name", "jane.doe@example.org", "The characteristics of someone or something");

        // Assert
        assertEquals("Name", actualAuthor.getName());
        assertEquals("The characteristics of someone or something", actualAuthor.getDescription());
        assertEquals("jane.doe@example.org", actualAuthor.getEmail());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(29791, (new Author()).hashCode());
        assertEquals(84251853,
                (new Author("Name", "jane.doe@example.org", "The characteristics of someone or something")).hashCode());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertNotEquals((new Author()), "obj");
    }

    @Test
    public void testEquals2() {
        // Arrange
        Author author = new Author();

        // Act and Assert
        assertEquals(new Author(), author);
    }

    @Test
    public void testEquals3() {
        // Arrange
        Author obj = new Author("Name", "jane.doe@example.org", "The characteristics of someone or something");

        // Act and Assert
        assertNotEquals(obj, (new Author()));
    }

    @Test
    public void testEquals4() {
        // Arrange
        Author author = new Author("Name", "Email", "The characteristics of someone or something");

        // Act and Assert
        assertNotEquals(new Author("Name", "jane.doe@example.org", "The characteristics of someone or something"), author);
    }

    @Test
    public void testEquals5() {
        // Arrange
        Author author = new Author("Name", "jane.doe@example.org", "Description");

        // Act and Assert
        assertNotEquals(new Author("Name", "jane.doe@example.org", "The characteristics of someone or something"), author);
    }
}

