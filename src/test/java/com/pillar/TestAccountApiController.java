package com.pillar;

import com.pillar.cardholder.Cardholder;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestAccountApiController {

    @Test
    public void accountApiControllerExists() {
        AccountApiController controller = new AccountApiController();

        assertNotNull(controller);
    }

    @Test
    public void createAccountFromCardholder() {
        Cardholder cardholder = new Cardholder("Steve", "Goliath", "123-45-6788");
        AccountApiController controller = new AccountApiController();
    }
}
