package com.pillar;

import com.pillar.account.Account;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestAccount {

    @Test
    public void twoAccountsAreEqualIfTheirIdsAreEqual() {
        Account account1 = new Account(1);
        Account account2 = new Account(1);

        assertEquals(account1, account2);
    }

    @Test
    public void twoAccountsAreNotEqualIfTheirIdsAreNotEqual() {
        Account account1 = new Account(1);
        Account account2 = new Account(2);

        assertNotEquals(account1, account2);
    }
}
