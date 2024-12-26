package com.example.Sunil_ProductCatalogService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel{

    private String name;

    private String description;

    private Double amount;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
