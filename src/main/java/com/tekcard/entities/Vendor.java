package com.tekcard.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonProperty
    public int id;
//    @JsonProperty
    public String name;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Distributor.class)
    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Set<Distributor> distributors;

    @Transient
    public double totalProfits;

    @Transient
    public int distributorCount;
}
