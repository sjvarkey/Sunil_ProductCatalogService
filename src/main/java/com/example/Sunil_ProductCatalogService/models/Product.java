package com.example.Sunil_ProductCatalogService.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends BaseModel{

    private String title;

    private String description;

    private String ImageUrl;

    private Double amount;

    @ManyToOne(cascade = CascadeType.ALL)
    Category category;

    private Boolean isPrimeSpecific;
}
