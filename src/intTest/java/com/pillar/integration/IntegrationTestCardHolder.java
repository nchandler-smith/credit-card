package com.pillar.integration;

import com.pillar.cardholder.CardHolder;
import com.pillar.cardholder.CardHolderRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@Rollback
@RunWith(SpringRunner.class)
public class IntegrationTestCardHolder {

    @Autowired
    CardHolderRepository cardHolderRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testEmptyCardHolderTableHasNoRecords() {
        List<CardHolder> cardHolders = cardHolderRepository.findAll();

        assertEquals(0, cardHolders.size());
    }

    @Test
    @Transactional
    public void testOneEntryInCardHolderTableReturnsThatEntry() {
        jdbcTemplate.update("INSERT INTO card_holder SET id=?, name=?, ssn=?", 1, "Steve Goliath", "123-45-6789");

        CardHolder cardHolder = cardHolderRepository.getOne(1);

        assertEquals(java.util.Optional.ofNullable(1), java.util.Optional.ofNullable(cardHolder.getId()));
        assertEquals("Steve Goliath", cardHolder.getName());
        assertEquals("123-45-6789", cardHolder.getSsn());
    }

    @After
    @Transactional
    public void tearDown() {
        jdbcTemplate.update("DELETE FROM card_holder");
    }
}
