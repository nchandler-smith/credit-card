package com.pillar.cucumber;

import cucumber.api.java.en.Given;

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
}
