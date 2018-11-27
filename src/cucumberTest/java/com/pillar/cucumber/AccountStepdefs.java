package com.pillar.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

public class AccountStepdefs {
    private String ssn;
    private String cardholderName;
    private String merchant;

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
        final HttpStatus status = response.statusCode();
        final Map<String, String> body = response.bodyToMono(Map.class).block();
    }
}
