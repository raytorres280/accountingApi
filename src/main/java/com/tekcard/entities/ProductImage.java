package com.tekcard.entities;

import jakarta.persistence.*;

@Entity
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String imageUrl;

    @ManyToOne
    public Product product;
}
