package com.example.Sunil_ProductCatalogService.repos;

import com.example.Sunil_ProductCatalogService.models.Category;
import com.example.Sunil_ProductCatalogService.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    public void testFetchTypes(){
        Category category = categoryRepo.findById(2L).get();
        for(Product product: category.getProducts()){
            System.out.println(product.getDescription());
        }
    }
}