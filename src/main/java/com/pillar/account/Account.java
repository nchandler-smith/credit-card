package com.pillar.account;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Account {
    @Id
    private Integer id;
    private String cardNumber;

    public Account (Integer id) {
        this.id = id;
        this.cardNumber = UUID.randomUUID().toString();
    }

    public Integer getId() { return this.id; }

    public String getCardNumber() { return this.cardNumber; }

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
