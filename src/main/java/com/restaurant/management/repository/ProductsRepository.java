package com.restaurant.management.repository;

import com.restaurant.management.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Pranto on 21-Nov-17.
 */
public interface ProductsRepository extends JpaRepository<Items, Long> {
}
