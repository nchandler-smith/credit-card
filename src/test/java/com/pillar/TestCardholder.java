package com.pillar;

import com.pillar.cardholder.Cardholder;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;


public class TestCardholder {

    private Cardholder cardholder1;

    @Before
    public void setup() {
        cardholder1 = new Cardholder(1, "Steve", "Goliath");
    }

    @Test
    public void twoCardholdersAreEqualIfTheirIdsAreIdentical() {
        Cardholder cardholder2 = new Cardholder(1, "Steve", "Goliath");

        assertEquals(cardholder1, cardholder2);
    }

    @Test
    public void twoCardholderAreNotEqualIfTheirIdsAreNotIdentical() {
        Cardholder cardholder2 = new Cardholder(2, "Steve", "Goliath");

        assertNotEquals(cardholder1, cardholder2);
    }

    @Test
    public void aCardholderIsNotEqualToNull() {
        assertNotEquals(cardholder1, null);
    }

    @Test
    public void aCardholderIsEqualToItself() {
        assertEquals(cardholder1, cardholder1);
    }

    @Test
    public void aCardholderIsNotEqualToObjectOfDifferentClass() {
        assertNotEquals(cardholder1, new HashMap<>());
    }

    @Test
    public void aCardholderHasAFirstName() {
        assertTrue(cardholder1.getFirstName() instanceof String);
    }

    @Test
    public void aCardholderHasALastName() {
        assertTrue(cardholder1.getLastName() instanceof String);
    }
}
