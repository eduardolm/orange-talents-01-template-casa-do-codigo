package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.controller.request.StateRequestDto;
import br.com.zup.casadocodigo.exception.StateConversionException;
import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.model.State;
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
public class StateRepositoryTest {

    @Autowired
    private StateRepository repository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private TestEntityManager manager;

    @Test
    public void shouldReturnStateIfExists() throws StateConversionException {
        StateRequestDto newStateRequestDto = new StateRequestDto("Alagoas", "Brasil");
        State newState = newStateRequestDto.convertStateRequestToState(countryRepository);
        manager.persist(newState);

        Optional<State> state = repository.findStateByName("Alagoas");

        assertNotNull(state);
        assertFalse(state.isEmpty());
        assertDoesNotThrow(state::get);
        assertEquals("Alagoas", state.get().getName());
    }

    @Test
    public void shouldBeEmptyIfStateDoesNotExist() throws StateConversionException {
        StateRequestDto newStateRequestDto = new StateRequestDto("Alagoas", "Brasil");
        State newState = newStateRequestDto.convertStateRequestToState(countryRepository);
        manager.persist(newState);

        Optional<State> state = repository.findStateByName("Paraná");

        assertNotNull(state);
        assertTrue(state.isEmpty());
        assertThrows(NoSuchElementException.class, state::get);
    }
}
