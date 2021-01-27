package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.controller.request.BookRequestDto;
import br.com.zup.casadocodigo.exception.BookConversionException;
import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.model.Book;
import br.com.zup.casadocodigo.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TestEntityManager manager;

    @Test
    public void shouldReturnTrueIfBookExists() throws BookConversionException {
        Author newAuthor = new Author("Joshua Baker", "josh@email.com", "Test author");
        manager.persist(newAuthor);

        Category category = new Category("Terror");
        manager.persist(category);

        BookRequestDto newBook = new BookRequestDto("Terror na Antartida", "Resumo", "Sumário",
                new BigDecimal("35.40"), 120, "123456", LocalDate.of(2021, 05, 15),
                "Terror", "Joshua Baker");

        Book createdBook = newBook.convertBookRequestToBook(categoryRepository, authorRepository);
        manager.persist(createdBook);

        Optional<Book> book = repository.findById(createdBook.getId());

        assertTrue(repository.existsBookByTitle("Terror na Antartida"));
        assertEquals("Joshua Baker", book.get().getAuthor().getName());
        assertEquals("Terror na Antartida", book.get().getTitle());
    }

    @Test
    public void shouldReturnFalseIfBookDoesNotExist() throws BookConversionException {
        Author newAuthor = new Author("Joshua Baker", "josh@email.com", "Test author");
        manager.persist(newAuthor);

        Category category = new Category("Terror");
        manager.persist(category);

        BookRequestDto newBook = new BookRequestDto("Terror na Antartida", "Resumo", "Sumário",
                new BigDecimal("35.40"), 120, "123456", LocalDate.of(2021, 05, 15),
                "Terror", "Joshua Baker");

        Book createdBook = newBook.convertBookRequestToBook(categoryRepository, authorRepository);
        manager.persist(createdBook);

        Optional<Book> book = repository.findById(createdBook.getId());

        assertFalse(repository.existsBookByTitle("Fake Book Name"));
    }
}
