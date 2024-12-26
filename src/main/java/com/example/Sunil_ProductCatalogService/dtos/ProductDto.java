package com.example.Sunil_ProductCatalogService.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {

    private Long id;

    private String title;

    private String description;

    private String ImageUrl;

    private Double amount;

    private CategoryDto category;

}
