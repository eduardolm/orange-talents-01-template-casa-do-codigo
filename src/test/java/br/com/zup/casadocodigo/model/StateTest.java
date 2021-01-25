package br.com.zup.casadocodigo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {
    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(-1968044180, (new State("Name", new Country())).hashCode());
        assertEquals(-1965623785, (new State("Name", new Country("Name"))).hashCode());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertNotEquals((new State()), "obj");
        assertNotEquals((new State()), 0);
        assertNotEquals((new State("Name", new Country())), 1);
    }

    @Test
    public void testEquals2() {
        // Arrange
        State obj = new State("Name", new Country());

        // Act and Assert
        assertNotEquals(obj, (new State()));
    }

    @Test
    public void testEquals3() {
        // Arrange
        State state = new State("Name", new Country());

        // Act and Assert
        assertEquals(new State("Name", new Country()), state);
    }

    @Test
    public void testEquals4() {
        // Arrange
        State state = new State("Name", new Country("Name"));

        // Act and Assert
        assertNotEquals(new State("Name", new Country()), state);
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("Estado [Id: null,Nome: Name, País: null]", (new State("Name", new Country())).toString());
    }
}

