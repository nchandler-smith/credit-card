package com.pillar.cardholder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CardHolder {
    @Id
    private  Integer id = 1;
    private String name = "Steve Goliath";
    private String ssn = "123-45-6788";

    public Integer getId() { return this.id; }

    public String getName() { return this.name; }

    public String getSsn() { return this.ssn; }
}
