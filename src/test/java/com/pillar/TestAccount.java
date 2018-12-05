package com.pillar;

import com.pillar.account.Account;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestAccount {
    Account account1;

    @Before
    public void setuo() {
        account1 = new Account(1);
    }

    @Test
    public void twoAccountsAreEqualIfTheirIdsAreEqual() {
        Account account2 = new Account(1);

        assertEquals(account1, account2);
    }

    @Test
    public void twoAccountsAreNotEqualIfTheirIdsAreNotEqual() {
        Account account2 = new Account(2);

        assertNotEquals(account1, account2);
    }

    @Test
    public void anAccountIsNotEqualToNull() {
        assertNotEquals(account1, null);
    }
}
