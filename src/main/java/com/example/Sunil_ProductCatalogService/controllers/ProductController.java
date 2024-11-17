package com.example.Sunil_ProductCatalogService.controllers;

import com.example.Sunil_ProductCatalogService.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts(){
        return null;
    }

    @GetMapping("/products/{id}")
    public Product getProductsById(@PathVariable("id") Long productId){

        Product product = new Product();

        product.setId(productId);
        product.setTitle("Iphone16");
        product.setDescription("Yet Another same iphone");
        product.setAmount(135000D);

        return product;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){

        return null;
    }
}
