package com.pillar.integration;

import com.pillar.account.Account;
import com.pillar.account.AccountRepository;
import com.pillar.merchant.Merchant;
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
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@Rollback
@RunWith(SpringRunner.class)
public class IntegrationTestAccount {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testEmptyAccountTableHasNoRecords() {
        List<Account> accounts = accountRepository.findAll();

        assertEquals(0, accounts.size());
    }

    @Test
    @Transactional
    public void testAccountTableWithOneRecordReturnsThatRecord() {
        String cardNumber = UUID.randomUUID().toString();
        insertRecords(cardNumber);

        Account account = accountRepository.getOne(1);

        assertEquals(java.util.Optional.of(1), java.util.Optional.of(account.getId()));
        assertEquals(cardNumber, account.getCardNumber());
        assertEquals(java.util.Optional.of(10000.0), java.util.Optional.of(account.getCreditLimit()));
    }

    @Test
    @Transactional
    public void testAccountReferencesMerchant() {
        String cardNumber = UUID.randomUUID().toString();
        insertRecords(cardNumber);

        Account account = accountRepository.getOne(1);

        assertTrue(account.getMerchant() instanceof Merchant);
    }

    private void insertRecords(String cardNumber) {
        jdbcTemplate.update("INSERT INTO merchant SET id=?, name=?", 1, "Best Buy");
        jdbcTemplate.update("INSERT INTO card_holder SET id=?, name=?, ssn=?", 1, "Steve Goliath", "123-45-6789");
        jdbcTemplate.update("INSERT INTO account SET id=?, card_number=?, credit_limit=?, merchant_id=?, card_holder_id=?", 1, cardNumber, 10000.0, 1, 1);
    }

    @After
    @Transactional
    public void tearDown() {
        jdbcTemplate.update("DELETE FROM merchant");
        jdbcTemplate.update("DELETE FROM card_holder");
        jdbcTemplate.update("DELETE FROM account");
    }
}
