package com.pillar.cardHolderTests;

import com.pillar.cardHolder.CardHolder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestCardHolder {

    private CardHolder cardHolder;

    @Before
    public void setup() { cardHolder = new CardHolder(); }

    @Test
    public void aCardHolderNameHasAnId() { assertNotNull(cardHolder.getId()); }

    @Test
    public void aCardHolderNameIsNotNull() { assertNotNull(cardHolder.getName()); }

    @Test
    public void aCardHolderSsnIsNotNull() {  assertNotNull(cardHolder.getSsn()); }
}
