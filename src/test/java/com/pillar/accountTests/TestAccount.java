package com.pillar.accountTests;

import com.pillar.account.Account;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestAccount {

    Account account;

    @Before
    public void setup() {account = new Account(1, 10000.0); }

    @Test
    public void anAccountHasAnId() { assertNotNull(account.getId()); }

    @Test
    public void anAccountHasACardNumberUUIDAsString() {
        assertNotNull(account.getCardNumber());
        assertEquals(36, account.getCardNumber().length());
    }

    @Test
    public void anAccountHasACreditLimitOf10000() {
        assertEquals(10000.0, account.getCreditLimit(), 0.01);
    }
}
