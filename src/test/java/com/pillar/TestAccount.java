package com.pillar;

import com.pillar.account.Account;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAccount {

    @Test
    public void twoAccountsAreEqualIfTheirIdsAreEqual() {
        Account account1 = new Account(1);
        Account account2 = new Account(1);

        assertEquals(account1, account2);
    }
}
