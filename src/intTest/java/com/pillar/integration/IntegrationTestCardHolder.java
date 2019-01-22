package com.pillar.integration;

import com.pillar.cardholder.CardHolder;
import com.pillar.cardholder.CardHolderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@Rollback
@RunWith(SpringRunner.class)
public class IntegrationTestCardHolder {

    @Autowired
    CardHolderRepository cardHolderRepository;

    @Test
    public void testEmptyCardHolderTableHasNoRecords() {
        List<CardHolder> cardHolders = cardHolderRepository.findAll();

        assertEquals(0, cardHolders.size());

    }
}
