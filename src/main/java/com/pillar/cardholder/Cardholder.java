package com.pillar.cardholder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cardholder {
    @Id
    private Integer id;

    public Cardholder(Integer id){
        this.id = id;
    }

    @Override
    public boolean equals(Object other){
        return true;

    }
}
