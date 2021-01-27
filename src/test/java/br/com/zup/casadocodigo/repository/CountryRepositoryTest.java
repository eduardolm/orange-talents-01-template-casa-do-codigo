package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.model.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CountryRepositoryTest {

    @Autowired
    private CountryRepository repository;

    @Autowired
    private TestEntityManager manager;

    @Test
    public void shouldReturnCountryIfExists() {
        Country newCountry = new Country("Paraguai");
        manager.persist(newCountry);

        Optional<Country> country = repository.findCountryByName("Paraguai");

        assertNotNull(country);
        assertFalse(country.isEmpty());
        assertDoesNotThrow(country::get);
        assertEquals("Paraguai", country.get().getName());
    }

    @Test
    public void shouldBeEmptyIfCountryDoesNotExist() {
        Country newCountry = new Country("Paraguai");
        manager.persist(newCountry);

        Optional<Country> country = repository.findCountryByName("China");

        assertNotNull(country);
        assertTrue(country.isEmpty());
        assertThrows(NoSuchElementException.class, country::get);
    }
}
