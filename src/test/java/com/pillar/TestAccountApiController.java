package com.pillar;

import com.pillar.account.Account;
import com.pillar.cardholder.Cardholder;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class TestAccountApiController {

    @Test
    public void accountApiControllerExists() {
        AccountApiController controller = new AccountApiController();

        assertNotNull(controller);
    }

    @Test
    public void createAccountFromCardholderReturnsNotNull() {
        Cardholder cardholder = new Cardholder("Steve", "Goliath", "123-45-6788");
        AccountApiController controller = new AccountApiController();

        assertNotNull(controller.createAccount(cardholder));
    }

    @Test
    public void createAccountFromCardholderReturnsCardNumber() {
        Cardholder cardholder = new Cardholder("Steve", "Goliath", "123-45-6788");
        AccountApiController controller = new AccountApiController();

        Account account = controller.createAccount(cardholder);

        assertEquals(36, account.getCardNumber().length());
    }

    @Test
    public void createdAccountHas10000DollarCrditLimit() {
        Cardholder cardholder = new Cardholder("Steve", "Goliath", "123-45-6788");
        AccountApiController controller = new AccountApiController();

        Account account = controller.createAccount(cardholder);

        assertEquals((Double) 10000.00, account.getCreditLimit());
    }
}
