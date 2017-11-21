package com.restaurant.management.repository;

import com.restaurant.management.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Masum on 11/21/2017.
 */
public interface ItemsRepository extends JpaRepository<Items, Long> {

}
