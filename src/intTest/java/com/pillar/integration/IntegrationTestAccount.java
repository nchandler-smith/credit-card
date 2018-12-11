package com.pillar.integration;

import com.pillar.cardholder.Cardholder;
import com.pillar.cardholder.CardholderRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class IntegrationTestAccount {

    @Autowired
    private CardholderRepository cardholderRepository;

    @Test
    public void testEmptyCardholderTableHasNoRecords() {
        List<Cardholder> cardholders = cardholderRepository.findAll();

        assertEquals(0, cardholders.size());
    }
}
