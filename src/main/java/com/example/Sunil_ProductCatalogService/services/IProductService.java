package com.example.Sunil_ProductCatalogService.services;

import com.example.Sunil_ProductCatalogService.models.Product;

import java.util.List;

public interface IProductService {

        List<Product> getAllProducts();

        Product getProductById(Long id);

        Product createProduct(Product product);

        Product replaceProduct(Long id, Product product);
}
