package com.pillar.integration;

import com.pillar.account.Account;
import com.pillar.account.AccountRepository;
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
        jdbcTemplate.update("INSERT INTO account SET id=?, card_number=?, credit_limit=?", 1, cardNumber, 10000.0);

        Account account = accountRepository.getOne(1);

        assertEquals(java.util.Optional.of(1), java.util.Optional.of(account.getId()));
        assertEquals(cardNumber, account.getCardNumber());
        assertEquals(java.util.Optional.of(10000.0), java.util.Optional.of(account.getCreditLimit()));
    }

    @After
    @Transactional
    public void tearDown() {
        jdbcTemplate.update("DELETE FROM account");
    }
}
