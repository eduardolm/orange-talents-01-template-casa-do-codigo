package br.com.zup.casadocodigo.exception;

import br.com.zup.casadocodigo.controller.request.CustomerRequestDto;
import br.com.zup.casadocodigo.model.Customer;
import br.com.zup.casadocodigo.repository.CountryRepository;
import br.com.zup.casadocodigo.repository.CustomerRepository;
import br.com.zup.casadocodigo.repository.StateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ValidationErrorHandlerTest {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private TestEntityManager manager;

    @Test
    public void testHandleValidationErrors() {
        CustomerRequestDto newCustomer = new CustomerRequestDto("marlon@email.com", "Marlon",
                "Brando", "625.828.900-22", "Rua XV de novembro, 23", "apto. 1101",
                "Sombrio", "Brasil", "Santa Catarina", "4733331465", "11085-030");

        assertThrows(CustomerConversionException.class, () ->
                newCustomer.convertCustomerRequestDtoToCustomer(countryRepository, stateRepository));
    }
}
