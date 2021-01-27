package br.com.zup.casadocodigo.controller.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.model.Customer;
import br.com.zup.casadocodigo.model.State;
import org.junit.jupiter.api.Test;

public class CustomerRequestDtoTest {
    @Test
    public void testConstructor() {
        // Arrange
        Country country = new Country();

        // Act
        CustomerRequestDto actualCustomerRequestDto = new CustomerRequestDto(new Customer("jane.doe@example.org", "Jane",
                "Doe", "Document", "42 Main St", "Complement", "Oxford", country, new State(), "4105551212", "21654"));

        // Assert
        assertEquals("Doe", actualCustomerRequestDto.getLastName());
        assertEquals("Complement", actualCustomerRequestDto.getComplement());
        assertNull(actualCustomerRequestDto.getId());
        assertEquals("42 Main St", actualCustomerRequestDto.getAddress());
        assertEquals("jane.doe@example.org", actualCustomerRequestDto.getEmail());
        assertEquals("Oxford", actualCustomerRequestDto.getCity());
        assertEquals("21654", actualCustomerRequestDto.getZip());
        assertEquals("4105551212", actualCustomerRequestDto.getPhone());
        assertNull(actualCustomerRequestDto.getState());
        assertEquals("Jane", actualCustomerRequestDto.getFirstName());
        assertEquals("Document", actualCustomerRequestDto.getDocument());
        assertNull(actualCustomerRequestDto.getCountry());
    }

    @Test
    public void testConstructor2() {
        // Arrange
        Country country = new Country();

        // Act
        CustomerRequestDto actualCustomerRequestDto = new CustomerRequestDto(new Customer("Email", "Jane", "Doe",
                "Document", "42 Main St", "Complement", "Oxford", country, new State(), "4105551212", "21654"));

        // Assert
        assertEquals("Doe", actualCustomerRequestDto.getLastName());
        assertEquals("Complement", actualCustomerRequestDto.getComplement());
        assertNull(actualCustomerRequestDto.getId());
        assertEquals("42 Main St", actualCustomerRequestDto.getAddress());
        assertEquals("Email", actualCustomerRequestDto.getEmail());
        assertEquals("Oxford", actualCustomerRequestDto.getCity());
        assertEquals("21654", actualCustomerRequestDto.getZip());
        assertEquals("4105551212", actualCustomerRequestDto.getPhone());
        assertNull(actualCustomerRequestDto.getState());
        assertEquals("Jane", actualCustomerRequestDto.getFirstName());
        assertEquals("Document", actualCustomerRequestDto.getDocument());
        assertNull(actualCustomerRequestDto.getCountry());
    }
}

