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

    @Test
    public void anAccountIsEqualToItself() { assertEquals(account1, account1); }

    @Test
    public void anAccountIsNotEqualToObjectOfDifferentClass() {
        assertNotEquals(account1, new Integer(18));
    }

    @Test
    public void anAccountHasACreditCardNumberUUID() { assertEquals(36, account1.getCardNumber().length()); }

    @Test
    public void anAccountHasA10000CreditLimit() { assertEquals( (Double) 10000.00, account1.getCreditLimit()); }
}
