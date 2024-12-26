package com.example.Sunil_ProductCatalogService.repos;

import com.example.Sunil_ProductCatalogService.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
