package com.restaurant.management.services;



import com.restaurant.management.model.ProductsCategory;

import java.util.List;

/**
 * Created by Pranto on 21-Nov-17.
 */
public interface ProductCategoryService {


    List<ProductsCategory> getAllProductCategories();

    void saveProductCategory(ProductsCategory productsCategory);

    ProductsCategory updateProductCategory(long productsCategoryId);

    ProductsCategory edit(ProductsCategory productsCategory);

}
