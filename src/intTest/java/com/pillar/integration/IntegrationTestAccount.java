package com.pillar.integration;

import com.pillar.account.Account;
import com.pillar.account.AccountRepository;
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
public class IntegrationTestAccount {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void testEmptyAccountTableHasNoRecords() {
        List<Account> accounts = accountRepository.findAll();

        assertEquals(0, accounts.size());
    }
}
