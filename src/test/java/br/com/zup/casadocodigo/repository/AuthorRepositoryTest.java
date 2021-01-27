package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository repository;

    @Autowired
    private TestEntityManager manager;

    @Test
    public void shouldReturnTrueIfEmailExists() {

        Author author = new Author("Joshua Baker", "josh@email.com", "Test author");
        manager.persist(author);

        assertTrue(repository.existsAuthorByEmail("josh@email.com"));
    }

    @Test
    public void shouldReturnFalseIfEmailDoesNotExist() {
        Author author = new Author("Joshua Baker", "josh@email.com", "Test author");
        manager.persist(author);

        assertTrue(repository.existsAuthorByEmail("josh@email.com"));
        assertFalse(repository.existsAuthorByEmail("invalid@email.com"));
    }
}
