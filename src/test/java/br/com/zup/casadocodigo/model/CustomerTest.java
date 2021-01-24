package br.com.zup.casadocodigo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerTest {

    @Test
    public void shouldCreateNewObjectInstanceNoArgsConstructor() {
        Customer customer = new Customer();

        assertEquals(Customer.class, customer.getClass());
        assertNull(customer.getId());
        assertNull(customer.getEmail());
        assertNull(customer.getFirstName());
        assertNull(customer.getLastName());
        assertNull(customer.getDocument());
        assertNull(customer.getAddress());
        assertNull(customer.getComplement());
        assertNull(customer.getCity());
        assertNull(customer.getCountry());
        assertNull(customer.getState());
        assertNull(customer.getPhone());
        assertNull(customer.getZip());
    }
}
