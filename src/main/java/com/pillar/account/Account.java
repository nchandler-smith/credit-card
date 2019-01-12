package com.pillar.account;

import java.util.UUID;

public class Account {

    private Integer id = 1;
    private String cardNumber = "1";

    public Account() {
        this.id = 1;
        this.cardNumber = UUID.randomUUID().toString();
    }

    public Integer getId() { return this.id; }

    public String getCardNumber() { return this.cardNumber; }
}
