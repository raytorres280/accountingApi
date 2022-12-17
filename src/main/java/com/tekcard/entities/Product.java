package com.tekcard.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;
//import org.hibernate.mapping.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    public int id;

    @JsonProperty
    public String title;

    @JsonProperty
    public String description;

    @JsonProperty
    public int price;

    @JsonProperty
    public double discountPercentage;

    @JsonProperty
    public double rating;

    @JsonProperty
    public int stock;

    @JsonProperty
    public String brand;

    @JsonProperty
    public String category;

    @JsonProperty
    public String thumbnail;

//    @JsonProperty
    @OneToMany(fetch = FetchType.LAZY)
    public Set<ProductImage> imageFiles;

//    @JsonProperty
    @ManyToOne(fetch = FetchType.LAZY)
    public Vendor vendor;

    @JsonProperty
    public String [] images;

}
