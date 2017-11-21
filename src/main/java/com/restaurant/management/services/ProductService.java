package com.restaurant.management.services;

import com.restaurant.management.model.Products;

import java.util.List;

/**
 * Created by Pranto on 21-Nov-17.
 */
public interface ProductService {

    Products findByProductName(String productName);

    List<Products> getAllProducts();

    void saveProduct(Products products);

    Products edit(Products products);

    boolean deleteProductsCategory(Long postId);

}
