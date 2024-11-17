package com.example.Sunil_ProductCatalogService.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public class Category extends BaseModel{

    private String name;

    private String description;

    private Double amount;

    private List<Product> products;
}
