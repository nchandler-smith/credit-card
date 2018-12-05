package com.pillar.account;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    private Integer id;

    public Account (Integer id) {
        this.id = id;
    }

    public Integer getId() { return this.id; }

    @Override
    public boolean equals(Object other){
        return this.id.equals(((Account)other).getId());
    }
}
