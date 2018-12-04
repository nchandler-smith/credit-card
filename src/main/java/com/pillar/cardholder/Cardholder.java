package com.pillar.cardholder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cardholder {
    @Id
    private Integer id;
    private String firstName;

    public Cardholder(Integer id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public Integer getId(){ return this.id; }

    public String getFirstName() { return this.firstName; }

    @Override
    public boolean equals(Object other){
        if (other == null) {
            return false;
        }

        if (this.getClass() != other.getClass()) {
            return false;
        }

        return this.id.equals(((Cardholder)other).getId());

    }
}
