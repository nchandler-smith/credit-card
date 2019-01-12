package com.pillar.accountTests;

import com.pillar.account.Account;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestAccount {

    @Test
    public void anAccountHasAnId() {
        Account account = new Account();

        assertNotNull(account.getId());
    }
}
