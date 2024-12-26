package com.example.Sunil_ProductCatalogService.repos;

import com.example.Sunil_ProductCatalogService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);
    List<Product> findProductByAmountBetween(Double low, Double high);

    //List<Product> findProductByIsPrimeSpecific(Boolean value);
    //Another way
    List<Product> findProductByIsPrimeSpecificTrue();

    @Query("select p.description from Product p where p.id=?1")
    String findProductDescriptionFromProductId(Long id);

    @Query("SELECT c.name from Category c join Product p on p.category.id=c.id where p.id=:id")
    String findCategoryNameByProductId(Long id);
}

