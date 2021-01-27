package br.com.zup.casadocodigo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.model.Customer;
import br.com.zup.casadocodigo.model.State;
import org.junit.jupiter.api.Test;

public class CustomerDetailDtoTest {
    @Test
    public void testConstructor() {
        // Arrange
        Country country = new Country();

        // Act
        CustomerDetailDto actualCustomerDetailDto = new CustomerDetailDto(new Customer("jane.doe@example.org", "Jane",
                "Doe", "Document", "42 Main St", "Complement", "Oxford", country, new State(), "4105551212", "21654"));

        // Assert
        assertEquals("Doe", actualCustomerDetailDto.getLastName());
        assertEquals("Complement", actualCustomerDetailDto.getComplement());
        assertNull(actualCustomerDetailDto.getId());
        assertEquals("42 Main St", actualCustomerDetailDto.getAddress());
        assertEquals("jane.doe@example.org", actualCustomerDetailDto.getEmail());
        assertEquals("Oxford", actualCustomerDetailDto.getCity());
        assertEquals("21654", actualCustomerDetailDto.getZip());
        assertEquals("4105551212", actualCustomerDetailDto.getPhone());
        assertEquals("Informação não disponível.", actualCustomerDetailDto.getState());
        assertEquals("Jane", actualCustomerDetailDto.getFirstName());
        assertEquals("Document", actualCustomerDetailDto.getDocument());
        assertNull(actualCustomerDetailDto.getCountry());
    }

    @Test
    public void testConstructor2() {
        // Arrange
        Country country = new Country();

        // Act
        CustomerDetailDto actualCustomerDetailDto = new CustomerDetailDto(new Customer("Informação não disponível.", "Jane",
                "Doe", "Document", "42 Main St", "Complement", "Oxford", country, new State(), "4105551212", "21654"));

        // Assert
        assertEquals("Doe", actualCustomerDetailDto.getLastName());
        assertEquals("Complement", actualCustomerDetailDto.getComplement());
        assertNull(actualCustomerDetailDto.getId());
        assertEquals("42 Main St", actualCustomerDetailDto.getAddress());
        assertEquals("Informação não disponível.", actualCustomerDetailDto.getEmail());
        assertEquals("Oxford", actualCustomerDetailDto.getCity());
        assertEquals("21654", actualCustomerDetailDto.getZip());
        assertEquals("4105551212", actualCustomerDetailDto.getPhone());
        assertEquals("Informação não disponível.", actualCustomerDetailDto.getState());
        assertEquals("Jane", actualCustomerDetailDto.getFirstName());
        assertEquals("Document", actualCustomerDetailDto.getDocument());
        assertNull(actualCustomerDetailDto.getCountry());
    }
}

