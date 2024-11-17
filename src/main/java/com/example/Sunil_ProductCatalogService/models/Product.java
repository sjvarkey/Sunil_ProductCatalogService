package com.example.Sunil_ProductCatalogService.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Product extends BaseModel{

    private String title;

    private String description;

    private String ImageUrl;

    private Double amount;

    private Category category;
}
