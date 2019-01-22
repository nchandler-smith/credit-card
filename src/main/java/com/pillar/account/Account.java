package com.pillar.account;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Account {

    @Id
    private Integer id;
    private String cardNumber;
    private Double creditLimit;

    public Account() {
        this.cardNumber = UUID.randomUUID().toString();
    }

    public Account(Integer id, Double creditLimit) {
        this.id = id;
        this.cardNumber = UUID.randomUUID().toString();
        this.creditLimit = 10000.0;
    }

    public Account(Integer id, String cardNumber, Double creditLimit) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
    }

    public Integer getId() { return this.id; }

    public String getCardNumber() { return this.cardNumber; }

    public Double getCreditLimit() { return this.creditLimit; }
}