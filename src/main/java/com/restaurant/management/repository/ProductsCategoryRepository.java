package com.restaurant.management.repository;

import com.restaurant.management.model.Products;
import com.restaurant.management.model.ProductsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Pranto on 21-Nov-17.
 */
public interface ProductsCategoryRepository extends JpaRepository<ProductsCategory, Long> {

}
