package com.pillar.account;

import java.util.UUID;

public class Account {

    private final Integer id = 1;
    private String cardNumber;
    private final Double creditLimit = 10000.0;

    public Account() {
        this.cardNumber = UUID.randomUUID().toString();
    }

    public Integer getId() { return this.id; }

    public String getCardNumber() { return this.cardNumber; }

    public Double getCreditLimit() { return this.creditLimit; }
}