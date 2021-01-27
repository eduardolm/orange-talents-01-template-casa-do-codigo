package br.com.zup.casadocodigo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.model.Customer;
import br.com.zup.casadocodigo.model.State;
import org.junit.jupiter.api.Test;

public class CustomerDtoTest {
    @Test
    public void testConstructor() {
        // Arrange and Act
        CustomerDto actualCustomerDto = new CustomerDto(new Customer());

        // Assert
        assertNull(actualCustomerDto.getLastName());
        assertNull(actualCustomerDto.getId());
        assertNull(actualCustomerDto.getFirstName());
    }

    @Test
    public void testConstructor2() {
        // Arrange
        Country country = new Country();

        // Act
        CustomerDto actualCustomerDto = new CustomerDto(new Customer("Email", "Jane", "Doe", "Document", "42 Main St",
                "Complement", "Oxford", country, new State(), "4105551212", "21654"));

        // Assert
        assertEquals("Doe", actualCustomerDto.getLastName());
        assertNull(actualCustomerDto.getId());
        assertEquals("Jane", actualCustomerDto.getFirstName());
    }
}

