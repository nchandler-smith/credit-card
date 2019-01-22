package com.pillar.account;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Account {

    @Id
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