package com.restaurant.management.repository;

import com.restaurant.management.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Pranto on 21-Nov-17.
 */
public interface ProductsRepository extends JpaRepository<Products, Long> {
}
