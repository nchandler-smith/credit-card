package com.pillar.integration;

import com.pillar.cardholder.Cardholder;
import com.pillar.cardholder.CardholderRepository;
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
@Transactional
@Rollback
@RunWith(SpringRunner.class)
public class IntegrationTestAccount {
    private static final int TEST_ID = 1;
    private static final String TEST_FIRST_NAME = "Steve";
    private static final String TEST_LAST_NAME = "Goliath";
    private static final String TEST_SSN = "123-45-6788";

    @Autowired
    private CardholderRepository cardholderRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testEmptyCardholderTableHasNoRecords() {
        List<Cardholder> cardholders = cardholderRepository.findAll();

        assertEquals(0, cardholders.size());
    }

    @Test
    public void testTableWithOneCardholderReturnsFirstNameFromRepository() {

        insertCardholderRecord();

        Cardholder cardholder = cardholderRepository.getOne(TEST_ID);

        assertEquals(TEST_FIRST_NAME, cardholder.getFirstName());
    }

    @Test
    public void testTableWithOneCardholderReturnsLastNameFromRepository() {

        insertCardholderRecord();

        Cardholder cardholder = cardholderRepository.getOne(TEST_ID);

        assertEquals(TEST_LAST_NAME, cardholder.getLastName());
    }

    @Test
    public void testTableWithOneCardholderReturnsSsnFromRepository() {
        insertCardholderRecord();

        Cardholder cardholder = cardholderRepository.getOne(TEST_ID);

        assertEquals(TEST_SSN, cardholder.getSsn());
    }

    @After
    public void tearDown() {
        jdbcTemplate.update("SET FOREIGN_KEY_CHECKS = 0");
        jdbcTemplate.update("TRUNCATE account");
        jdbcTemplate.update("TRUNCATE cardholder");
        jdbcTemplate.update("TRUNCATE merchant");
    }

    private void insertCardholderRecord() {
        jdbcTemplate.update("INSERT INTO cardholder SET id=?, first_name=?, last_name=?, ssn=?",
                TEST_ID, TEST_FIRST_NAME, TEST_LAST_NAME, TEST_SSN);
    }
}
