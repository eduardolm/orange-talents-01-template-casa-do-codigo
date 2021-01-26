package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private TestEntityManager manager;

    @Test
    public void shouldReturnCategoryIfExists() {
        Category newCategory = new Category("Terror");
        manager.persist(newCategory);

        Optional<Category> category = repository.findCategoryByName("Terror");

        assertNotNull(category);
        assertFalse(category.isEmpty());
        assertDoesNotThrow(category::get);
        assertEquals("Terror", category.get().getName());
    }

    @Test
    public void shouldBeEmptyIfCategoryDoesNotExist() {
        Category newCategory = new Category("Terror");
        manager.persist(newCategory);

        Optional<Category> actualCatgory = repository.findCategoryByName("Auto Ajuda");

        assertNotNull(actualCatgory);
        assertTrue(actualCatgory.isEmpty());
        assertThrows(NoSuchElementException.class, actualCatgory::get);
    }
}
