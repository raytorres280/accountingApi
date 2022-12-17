package com.tekcard.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Salesman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;

    @ManyToOne
    public Distributor distributor;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn (name = "seller_id", referencedColumnName = "id")
    public Set<Sale> sales;
}
