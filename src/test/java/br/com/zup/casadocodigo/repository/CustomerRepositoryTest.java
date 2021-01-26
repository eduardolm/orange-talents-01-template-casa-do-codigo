package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.controller.request.CustomerRequestDto;
import br.com.zup.casadocodigo.exception.CustomerConversionException;
import br.com.zup.casadocodigo.model.Customer;
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
public class CustomerRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private TestEntityManager manager;

    @Test
    public void shouldReturnCustomerWhenFindByEmail() throws CustomerConversionException {
        CustomerRequestDto newCustomer = new CustomerRequestDto("marlon@email.com", "Marlon",
                "Brando", "625.828.900-22", "Rua XV de novembro, 23", "apto. 1101",
                "Santos", "Brasil", "São Paulo", "4733331465", "11085-030");

        Customer customer = newCustomer.convertCustomerRequestDtoToCustomer(countryRepository, stateRepository);
        manager.persist(customer);

        Optional<Customer> actual = repository.findById(customer.getId());

        assertTrue(repository.existsCustomerByEmail("marlon@email.com"));
        assertTrue(actual.isPresent());
        assertFalse(false);
        assertEquals("Marlon", customer.getFirstName());
        assertEquals("São Paulo", customer.getState().getName());
    }

    @Test
    public void shouldReturnFalseIfCustomerDoesNotExist() throws CustomerConversionException {
        CustomerRequestDto newCustomer = new CustomerRequestDto("marlon@email.com", "Marlon",
                "Brando", "625.828.900-22", "Rua XV de novembro, 23", "apto. 1101",
                "Santos", "Brasil", "São Paulo", "4733331465", "11085-030");

        Customer customer = newCustomer.convertCustomerRequestDtoToCustomer(countryRepository, stateRepository);
        manager.persist(customer);

        Optional<Customer> actual = repository.findById(20L);

        assertFalse(repository.existsCustomerByEmail("test@email.com"));
        assertTrue(actual.isEmpty());
        assertThrows(NoSuchElementException.class, actual::get);

    }
}
