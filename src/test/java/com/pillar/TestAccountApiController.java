package com.pillar;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestAccountApiController {

    @Test
    public void accountApiCotrollerExists() {
        AccountApiController controller = new AccountApiController();

        assertNotNull(controller);
    }
}
