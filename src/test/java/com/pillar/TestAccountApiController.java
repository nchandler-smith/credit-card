package com.pillar;

import com.pillar.account.Account;
import com.pillar.cardholder.Cardholder;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class TestAccountApiController {
    private final String TEST_FIRST_NAME = "Steve";
    private final String TEST_LAST_NAME = "Goliath";
    private final String TEST_SSN = "123-45-6788";

    @Test
    public void accountApiControllerExists() {
        AccountApiController controller = new AccountApiController();

        assertNotNull(controller);
    }

    @Test
    public void createAccountFromCardholderReturnsNotNull() {
        Cardholder cardholder = new Cardholder(TEST_FIRST_NAME, TEST_LAST_NAME,TEST_SSN);
        AccountApiController controller = new AccountApiController();

        assertNotNull(controller.createAccount(cardholder));
    }

    @Test
    public void createAccountFromCardholderReturnsCardNumber() {
        Cardholder cardholder = new Cardholder(TEST_FIRST_NAME, TEST_LAST_NAME, TEST_SSN);
        AccountApiController controller = new AccountApiController();

        Account account = controller.createAccount(cardholder);

        assertEquals(36, account.getCardNumber().length());
    }

    @Test
    public void createdAccountHas10000DollarCrditLimit() {
        Cardholder cardholder = new Cardholder(TEST_FIRST_NAME, TEST_LAST_NAME, TEST_SSN);
        AccountApiController controller = new AccountApiController();

        Account account = controller.createAccount(cardholder);

        assertEquals((Double) 10000.00, account.getCreditLimit());
    }
}
