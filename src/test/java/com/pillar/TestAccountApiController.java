package com.pillar;

import com.pillar.account.Account;
import com.pillar.account.AccountRepository;
import com.pillar.cardholder.CardholderRepository;
import com.pillar.merchant.MerchantRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class TestAccountApiController {
    AccountApiController controller;
    CardholderRepository cardholderRepository;
    AccountRepository accountRepository;
    MerchantRepository merchantRepository;

    @Before
    public void setup() {
        controller = new AccountApiController(cardholderRepository, merchantRepository, accountRepository);
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
