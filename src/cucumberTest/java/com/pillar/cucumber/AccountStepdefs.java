package com.pillar.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AccountStepdefs {
    private String ssn;
    private String cardholderName;
    private String merchant;

    private HttpStatus status;
    private Map body;

    @Given("a cardholder Name: {string}, SSN: {string}, Merchant: {string}")
    public void aCardholderNameSsnMerchant(String cardholderName, String ssn, String merchant){
        this.cardholderName = cardholderName;
        this.ssn = ssn;
        this.merchant = merchant;
    }

    @When("a request is made to create an account for this cardholder")
    public void aRequestIsMadeToCreateAnAccountForThisCardholder(){
        final String endpoint = System.getProperty("integration-endpoint", "http://localhost:8080");
        final WebClient client = WebClient.create(endpoint);

        final HashMap<String, String> accountInfo = new HashMap<>();
        accountInfo.put("cardHolderName", this.cardholderName);
        accountInfo.put("ssn", this.ssn);
        accountInfo.put("merchant", merchant);

        final ClientResponse response = client
                                            .post()
                                            .uri("api/account/create")
                                            .body(BodyInserters.fromObject(accountInfo))
                                            .exchange()
                                            .block();
        this.status = response.statusCode();
        this.body = response.bodyToMono(Map.class).block();
    }

    @Then("a new account is created and a new card number is issued to that account and returned")
    public void aNewAccountIsCreatedAndANewCardNumberIsIssuedToThatAccountAndReturned(){
        assertEquals(HttpStatus.CREATED, this.status);
        assertTrue(body.containsKey("cardNumber"));
        assertNotNull(body.get("cardNumber"));
    }

    @And("a credit limit of 10,000 is assigned")
    public void aCreditLimitOf10000IsAssigned(){
        assertTrue(body.containsKey("creditLimit"));
        assertNotNull(body.get("creditLimit"));
    }
}
