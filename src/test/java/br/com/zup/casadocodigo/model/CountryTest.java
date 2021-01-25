package br.com.zup.casadocodigo.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountryTest {
    @Test
    public void testConstructor() {
        // Arrange and Act
        Country actualCountry = new Country();

        // Assert
        assertNull(actualCountry.getId());
        assertNull(actualCountry.getName());
        List<State> states = actualCountry.getStates();
        assertTrue(states instanceof java.util.ArrayList);
        assertEquals("País [Id: null, Nome: null]", actualCountry.toString());
        assertTrue(states.isEmpty());
    }

    @Test
    public void testConstructor2() {
        // Arrange, Act and Assert
        assertEquals("Name", (new Country("Name")).getName());
    }

    @Test
    public void testConstructor3() {
        // Arrange
        ArrayList<State> stateList = new ArrayList<State>();

        // Act
        Country actualCountry = new Country("Name", stateList);

        // Assert
        assertEquals("Name", actualCountry.getName());
        assertSame(stateList, actualCountry.getStates());
    }

    @Test
    public void testToCountryDto() {
        // Arrange, Act and Assert
        assertNull((new Country()).toCountryDto().getName());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(961, (new Country()).hashCode());
        assertEquals(2421356, (new Country("Name")).hashCode());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertNotEquals((new Country()), "obj");
    }

    @Test
    public void testEquals2() {
        // Arrange
        Country country = new Country();

        // Act and Assert
        assertEquals(new Country(), country);
    }

    @Test
    public void testEquals3() {
        // Arrange
        Country obj = new Country("Name");

        // Act and Assert
        assertNotEquals(obj, (new Country()));
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("País [Id: null, Nome: null]", (new Country()).toString());
    }
}

