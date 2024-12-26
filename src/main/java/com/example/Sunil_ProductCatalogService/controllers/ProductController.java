package com.example.Sunil_ProductCatalogService.controllers;


import com.example.Sunil_ProductCatalogService.dtos.CategoryDto;
import com.example.Sunil_ProductCatalogService.dtos.ProductDto;
import com.example.Sunil_ProductCatalogService.models.Category;
import com.example.Sunil_ProductCatalogService.models.Product;
import com.example.Sunil_ProductCatalogService.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

//    public ProductController(IProductService productService){
//        this.productService = productService;
//    }

    @GetMapping("/products")
    public List<ProductDto> getProducts() {

        List<Product> products = productService.getAllProducts();
        List<ProductDto> productDtos = new ArrayList<>();

        if(products !=null && !products.isEmpty()){
            for(Product product : products){
                ProductDto productDto = from(product);
                productDtos.add(productDto);
            }
            return productDtos;
        }
        return null;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductsById(@PathVariable("id") Long productId) {

//        Product product = new Product();
//
//        product.setId(productId);
//        product.setTitle("Iphone16");
//        product.setDescription("Yet Another same iphone");
//        product.setAmount(135000D);
        try {
            if (productId < 1) {
                throw new RuntimeException("Product Not found");
            }

            Product product = productService.getProductById(productId);
            if (product == null) return null;

            return new ResponseEntity<>(from(product), HttpStatus.OK);
        } catch(RuntimeException exception){
            //return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            throw exception;
        }

    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        Product product = from(productDto);
        Product response = productService.createProduct(product);
        return from(response);
    }

    @PutMapping("/products/{id}")
    public ProductDto replaceProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
        Product product = productService.replaceProduct(id, from(productDto));
        return from(product);
    }

    //Helper function to map productdto to product
    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setAmount(productDto.getAmount());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        //product.setIsPrimeSpecific(productDto.getIsPrimeSpecific());
        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            product.setCategory(category);
        }
        return product;
    }

    //Helper function to map product to productdto
    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setAmount(product.getAmount());
        productDto.setImageUrl(product.getImageUrl());
        //productDto.setIsPrimeSpecific(product.getIsPrimeSpecific());
        if (product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }

        return productDto;
    }


}