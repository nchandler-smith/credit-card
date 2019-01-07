package com.pillar.account;

import com.pillar.cardholder.Cardholder;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cardNumber;
    private Double creditLimit;

    @ManyToOne
    @JoinColumn(name = "cardholder_id")
    private Cardholder cardholder;

    public Account() {
        this.cardNumber = UUID.randomUUID().toString();
        this.creditLimit = 10000.0;
    }

    public Account(Integer id) {
        this.id = id;
        this.cardNumber = UUID.randomUUID().toString();
        this.creditLimit = 10000.00;
    }

    public Account(Cardholder cardholder) {
        this.cardholder = cardholder;
    }

    public Integer getId() { return this.id; }

    public String getCardNumber() { return this.cardNumber; }

    public Double getCreditLimit() { return this.creditLimit; }

    public Cardholder getCardholder() { return this.cardholder; }

    @Override
    public boolean equals(Object other){
        if(other == null) {
            return false;
        }

        if(this.getClass() != other.getClass()){
            return false;
        }

        return this.id.equals(((Account)other).getId());
    }
}
