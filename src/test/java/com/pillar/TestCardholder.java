package com.pillar;

import com.pillar.cardholder.Cardholder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestCardholder {

    private Cardholder cardholder1;

    @Before
    public void setup() {
        cardholder1 = new Cardholder(1);
    }

    @Test
    public void twoCardholdersAreEqualIfTheirIdsAreIdentical() {
        Cardholder cardholder2 = new Cardholder(1);

        assertEquals(cardholder1, cardholder2);
    }

    @Test
    public void twoCardholderAreNotEqualIfTheirIdsAreNotIdentical() {
        Cardholder cardholder2 = new Cardholder(2);

        assertNotEquals(cardholder1, cardholder2);
    }

    @Test
    public void aCardholderIsNotEqualToNull() {
        assertNotEquals(cardholder1, null);
    }
}
