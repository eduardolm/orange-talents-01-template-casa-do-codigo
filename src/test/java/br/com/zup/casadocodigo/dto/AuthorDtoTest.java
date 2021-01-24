package br.com.zup.casadocodigo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.zup.casadocodigo.model.Author;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class AuthorDtoTest {
    @Test
    public void testConstructor() {
        // Arrange and Act
        AuthorDto actualAuthorDto = new AuthorDto(new Author());

        // Assert
        assertNull(actualAuthorDto.getEmail());
        assertNull(actualAuthorDto.getName());
        assertNull(actualAuthorDto.getDescription());
        assertTrue(actualAuthorDto.getBooks().isEmpty());
    }

    @Test
    public void testConstructor2() {
        // Arrange and Act
        AuthorDto actualAuthorDto = new AuthorDto(
                new Author("]", "jane.doe@example.org", "The characteristics of someone or something"));

        // Assert
        assertEquals("jane.doe@example.org", actualAuthorDto.getEmail());
        assertEquals("]", actualAuthorDto.getName());
        assertEquals("The characteristics of someone or something", actualAuthorDto.getDescription());
        assertTrue(actualAuthorDto.getBooks().isEmpty());
    }

    @Test
    public void testToAuthor() {
        // Arrange and Act
        Author actualToAuthorResult = (new AuthorDto(new Author())).toAuthor();

        // Assert
        assertNull(actualToAuthorResult.getName());
        assertNull(actualToAuthorResult.getDescription());
        assertNull(actualToAuthorResult.getEmail());
    }

    @Test
    public void testToAuthorDto() {
        // Arrange, Act and Assert
        assertTrue(AuthorDto.toAuthorDto(new ArrayList<>()).isEmpty());
    }

    @Test
    public void testToAuthorDto2() {
        // Arrange
        ArrayList<Author> authorList = new ArrayList<>();
        authorList.add(new Author());

        // Act and Assert
        assertEquals(1, AuthorDto.toAuthorDto(authorList).size());
    }

    @Test
    public void testToAuthorDto3() {
        // Arrange
        ArrayList<Author> authorList = new ArrayList<>();
        authorList.add(new Author());
        authorList.add(new Author());

        // Act and Assert
        assertEquals(2, AuthorDto.toAuthorDto(authorList).size());
    }
}

