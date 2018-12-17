package com.pillar.cardholder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cardholder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String ssn;

    public Cardholder() {}

    public Cardholder(Integer id, String name, String ssn) {
        this.id = id;
        this.name = name;
        this.ssn = ssn;
    }

    public Cardholder(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    public Integer getId(){ return this.id; }

    public String getName() { return this.name; }

    public String getSsn() { return this.ssn; }

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
