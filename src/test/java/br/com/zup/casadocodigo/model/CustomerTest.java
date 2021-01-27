package br.com.zup.casadocodigo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("Customer[Id: 'null', E-mail: 'null', Nome: 'null', Sobrenome: 'null', Documento: 'null', Endereço:"
                + " 'null', Complemento: 'null', Cidade: 'null', País: 'null', Estado: 'Sem estado', Telefone: null,"
                + " CEP: null]", (new Customer()).toString());
        assertEquals(
                "Customer[Id: 'null', E-mail: 'jane.doe@example.org', Nome: 'Jane', Sobrenome: 'Doe', Documento:"
                        + " 'Document', Endereço: '42 Main St', Complemento: 'Complement', Cidade: 'Oxford', País: 'País [Id:"
                        + " null, Nome: null]', Estado: 'Sem estado', Telefone: 4105551212, CEP: 21654]",
                (new Customer("jane.doe@example.org", "Jane", "Doe", "Document", "42 Main St", "Complement", "Oxford",
                        new Country(), null, "4105551212", "21654")).toString());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(129082719, (new Customer()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        Country country = new Country();

        // Act and Assert
        assertEquals(1130104579, (new Customer("jane.doe@example.org", "Jane", "Doe", "Document", "42 Main St",
                "Complement", "Oxford", country, new State(), "4105551212", "21654")).hashCode());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertNotEquals((new Customer()), "obj");
    }

    @Test
    public void testEquals2() {
        // Arrange
        Customer customer = new Customer();

        // Act and Assert
        assertEquals(new Customer(), customer);
    }

    @Test
    public void testEquals3() {
        // Arrange
        Country country = new Country();
        Customer obj = new Customer("jane.doe@example.org", "Jane", "Doe", "Document", "42 Main St", "Complement", "Oxford",
                country, new State(), "4105551212", "21654");

        // Act and Assert
        assertNotEquals(obj, (new Customer()));
    }

    @Test
    public void testEquals4() {
        // Arrange
        Country country = new Country();
        Customer customer = new Customer("jane.doe@example.org", "First Name", "Doe", "Document", "42 Main St",
                "Complement", "Oxford", country, new State(), "4105551212", "21654");
        Country country1 = new Country();

        // Act and Assert
        assertNotEquals(new Customer("jane.doe@example.org", "Jane", "Doe", "Document", "42 Main St",
                "Complement", "Oxford", country1, new State(), "4105551212", "21654"), customer);
    }
}

