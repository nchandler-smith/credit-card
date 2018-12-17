package com.pillar;

import com.pillar.account.Account;
import com.pillar.cardholder.CardholderRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class TestAccountApiController {
    AccountApiController controller;
    CardholderRepository cardholderRepository;

    @Before
    public void setup() {
        controller = new AccountApiController(cardholderRepository);
    }

    @Test
    public void accountApiControllerExists() {
        assertNotNull(controller);
    }

    @Test
    public void createAccountFromCardholderReturnsNotNull() {
    assertNotNull(controller.createAccount());
    }

    @Test
    public void createAccountFromCardholderReturnsCardNumber() {
    Account account = controller.createAccount();

    assertEquals(36, account.getCardNumber().length());
    }

    @Test
    public void createdAccountHas10000DollarCrditLimit() {
        Account account = controller.createAccount();

    assertEquals((Double) 10000.00, account.getCreditLimit());
    }
}
