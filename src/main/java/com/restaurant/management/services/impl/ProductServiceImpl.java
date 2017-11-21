package com.restaurant.management.services.impl;

import com.restaurant.management.model.Products;
import com.restaurant.management.repository.ProductsRepository;
import com.restaurant.management.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pranto on 21-Nov-17.
 */

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductsRepository productsRepository;


    @Override
    public Products findByProductName(String productName) {
       List<Products> productsList= productsRepository.findAll();
       if (productsList != null){
           for (Products products :productsList) {
               if (productName.equalsIgnoreCase(products.getProductName())){
                   return products;
               }
           }
       }
        return null;
    }

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public void saveProduct(Products products) {

        productsRepository.save(products);
    }

    @Override
    public Products edit(Products products) {
        return null;
    }

    @Override
    public Products updateProduct(long productsId) {
        return productsRepository.findOne(productsId);
    }

    @Override
    public boolean deleteProductsCategory(Long postId) {
        return false;
    }
}
