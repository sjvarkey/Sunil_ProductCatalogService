package com.example.Sunil_ProductCatalogService.services;

import com.example.Sunil_ProductCatalogService.models.Product;
import com.example.Sunil_ProductCatalogService.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("sps")
@Primary
public class StorageProductService implements IProductService{

   @Autowired
   private ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct =  productRepo.findById(id);
        if(optionalProduct.isPresent()) return optionalProduct.get();

        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}