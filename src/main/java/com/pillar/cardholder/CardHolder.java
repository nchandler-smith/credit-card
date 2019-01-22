package com.pillar.cardholder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CardHolder {
    @Id
    private Integer id;
    private String name;
    private String ssn;

    public CardHolder() {}

    public CardHolder(Integer id, String name, String ssn) {
        this.id = id;
        this.name = name;
        this.ssn = ssn;
    }

    public Integer getId() { return this.id; }

    public String getName() { return this.name; }

    public String getSsn() { return this.ssn; }
}
