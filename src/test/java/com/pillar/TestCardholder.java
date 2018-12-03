package com.pillar;

import com.pillar.cardholder.Cardholder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCardholder {

    @Test
    public void twoCardholdersAreEqualIfTheirIdsAreIdentical() {
        Cardholder cardholder1 = new Cardholder(1);
        Cardholder cardholder2 = new Cardholder(1);

        assertEquals(cardholder1, cardholder2);
    }
}
