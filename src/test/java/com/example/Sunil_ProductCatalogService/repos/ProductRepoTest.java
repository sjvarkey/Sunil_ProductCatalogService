package com.example.Sunil_ProductCatalogService.repos;

import com.example.Sunil_ProductCatalogService.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    @Test
    @Transactional
    public void testQueries(){

       // List<Product> productList = productRepo.findProductByAmountBetween(10000D, 150000D);
//        List<Product> productList = productRepo.findProductByIsPrimeSpecificTrue();
//
//        for(Product product: productList){
//            System.out.println(product.getTitle() + " " + product.getAmount());
//        }
//        String desc = productRepo.findProductDescriptionFromProductId(2L);
//        System.out.println("Description: " + desc);

        String category = productRepo.findCategoryNameByProductId(2L);
        System.out.println("Category:" + category);
    }
}