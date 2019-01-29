package com.pillar.account;

import com.pillar.merchant.Merchant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Account {

    @Id
    private Integer id;
    private String cardNumber;
    private Double creditLimit;
    @ManyToOne
    @JoinColumn(name="merchant_id")
    private Merchant merchant;

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

    public Account(String cardNumber, Double creditLimit, Merchant merchant) {
        this.id = null;
        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
        this.merchant = merchant;
    }

    public Integer getId() { return this.id; }

    public String getCardNumber() { return this.cardNumber; }

    public Double getCreditLimit() { return this.creditLimit; }

    public Merchant getMerchant() { return this.merchant; }
}