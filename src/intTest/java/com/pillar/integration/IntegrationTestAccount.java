package com.pillar.integration;

import com.pillar.account.Account;
import com.pillar.account.AccountRepository;
import com.pillar.cardholder.Cardholder;
import com.pillar.cardholder.CardholderRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@Rollback
@RunWith(SpringRunner.class)
public class IntegrationTestAccount {
    private static final int TEST_ID = 1;
    private static final String TEST_FIRST_NAME = "Steve";
    private static final String TEST_LAST_NAME = "Goliath";
    private static final String TEST_SSN = "123-45-6788";
    private static final String TEST_CARD_NUMBER = "123456789012345678901234567890123456";
    private static final Double TEST_CREDIT_LIMIT = 10000.00;
    private static final Boolean TEST_ACTIVE = true;
    private static final String TEST_MERCHANT_NAME = "Best Buy";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CardholderRepository cardholderRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @LocalServerPort
    int randomServerPort;

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

    @Test
    public void testEmptyAccountTableHasNoRecords() {
        List<Account> accounts = accountRepository.findAll();

        assertEquals(0, accounts.size());
    }

    @Test
    public void testAccountWithOneNameReturnsAccountNumberFromRepository() {
        insertCardholderRecord();
        insertMerchantRecord();
        insertAccountRecord();

        Account account = accountRepository.getOne(TEST_ID);

        assertEquals(TEST_CARD_NUMBER, account.getCardNumber());
    }

    @Test
    public void testAccountApiCreateAccountReturnsStatusCreated() {
        HashMap<String, String> accountInfo = new HashMap<>();
        accountInfo.put("cardholderName", TEST_FIRST_NAME + " " + TEST_LAST_NAME);
        accountInfo.put("ssn", TEST_SSN);
        accountInfo.put("merchant", TEST_MERCHANT_NAME);

        final String endpoint = System.getProperty("integration-endpoint", "http://localhost:" + randomServerPort);
        final WebClient client = WebClient.create(endpoint);
        final ClientResponse response = client
                                            .post()
                                            .uri("api/Account/create")
                                            .body(BodyInserters.fromObject(accountInfo))
                                            .exchange()
                                            .block();
        final HttpStatus status = response.statusCode();

        assertEquals(HttpStatus.CREATED, status);
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

    private void insertMerchantRecord() {
        jdbcTemplate.update("INSERT INTO merchant SET id=?, name=?", TEST_ID, TEST_MERCHANT_NAME);
    }

    private void insertAccountRecord() {
        jdbcTemplate.update("INSERT INTO account SET id=?, card_number=?, credit_limit=?, active=?," +
                        "cardholder_id=?, merchant_id=?",
                TEST_ID, TEST_CARD_NUMBER, TEST_CREDIT_LIMIT, TEST_ACTIVE, TEST_ID, TEST_ID);
    }
}
