package com.pillar.cardHolderTests;

import com.pillar.cardHolder.CardHolder;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestCardHolder {

    @Test
    public void aCardHolderNameIsNotNull() {
        CardHolder cardHolder = new CardHolder();

        assertNotNull(cardHolder.getName());
    }

    @Test
    public void aCardHolderSsnIsNotNull() {
        CardHolder cardHolder = new CardHolder();

        assertNotNull(cardHolder.getSsn());
    }
}
