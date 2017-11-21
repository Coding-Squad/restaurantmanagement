package com.restaurant.management.services.impl;

import com.restaurant.management.model.ProductsCategory;
import com.restaurant.management.repository.ProductsCategoryRepository;
import com.restaurant.management.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pranto on 21-Nov-17.
 */

@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductsCategoryRepository productsCategoryRepository;

    @Override
    public List<ProductsCategory> getAllProductCategories() {
        return productsCategoryRepository.findAll();
    }

    @Override
    public void saveProductCategory(ProductsCategory productsCategory) {

        productsCategoryRepository.save(productsCategory);

    }

    @Override
    public ProductsCategory updateProductCategory(long productsCategoryId) {
        return productsCategoryRepository.findOne(productsCategoryId);
    }

    @Override
    public ProductsCategory edit(ProductsCategory productsCategory) {



        return null;
    }
}
