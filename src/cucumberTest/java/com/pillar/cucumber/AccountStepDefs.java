package com.pillar.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class AccountStepDefs {
    private String endpoint;
    private Map response;
    private final WebClient client;

    private String cardHolderName;
    private String ssn;
    private String merchantName;

    public AccountStepDefs() {
        endpoint = System.getProperty("integration-endpoint", "http://localhost:8080");
        client = WebClient.create(endpoint);
}

    @Given("a card holder Name: {string}, SSN: {string}, Merchant Name: {string}")
    public void aCardHolderNameSSNMerchantName(String cardHolderName, String ssn, String merchantName) {
        this.cardHolderName = cardHolderName;
        this.ssn = ssn;
        this.merchantName = merchantName;
    }

    @When("a request to create a new card is made")
    public void aRequestToCreateANewCardIsMade() {
        HashMap<String, String> accountSetupInfo = new HashMap<String, String>();
        accountSetupInfo.put("cardHolderName", cardHolderName);
        accountSetupInfo.put("ssm", ssn);
        accountSetupInfo.put("merchantName", merchantName);

        response = client
                .post()
                .uri("api/account/create")
                .body(BodyInserters.fromObject(accountSetupInfo))
                .exchange().block()
                .bodyToMono(Map.class)
                .block();
    }

    @Then("a card number is returned")
    public void aCardNumberIsReturned() {
        assertTrue(response.containsKey("cardNumber"));
        assertNotNull(response.get("cardNumber"));
        assertEquals(36, response.get("cardNumber").toString().length());
        }

    @Then("a credit limit of {double} is assigned.")
    public void aCreditLimitOfIsAssigned(Double creditLimit) {
        assertTrue(response.containsKey("creditLimit"));
        assertNotNull(response.get("creditLimit"));
        assertEquals(10000.0, response.get("creditLimit"));
    }
}
