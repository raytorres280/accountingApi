package com.tekcard.entities;

import jakarta.persistence.*;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;

    @ManyToOne
    public Product product;

    @ManyToOne
    public Salesman seller;

}
