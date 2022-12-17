package com.tekcard.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Vendor vendor;


    @OneToMany(fetch = FetchType.LAZY, targetEntity = Salesman.class)
    @JoinColumn (name = "distributor_id", referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Set<Salesman> salesmen;

    @Transient
    public int totalSalesmen;

    @Transient
    public double totalProfits;

    public double profitPercentagePerItem;


}
