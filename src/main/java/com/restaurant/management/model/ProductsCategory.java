package com.restaurant.management.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Programmer on 21-Nov-17.
 */

@Entity
@Table(name = "products_category")
public class ProductsCategory {
    //>>>>>deafult value for bean
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_category_Id")
    private Long id;

    @Column(name = "user_Id", nullable = false)
    private Long userId;

    @Column(name = "create_Date" , nullable = false)
    private Date createDate;

    @Column(name = "modified_Date" , nullable = false)
    private Date modifiedDate ;

    //>>>>>>>>>deafult value for bean end

    @Column(name = "product_category_name", nullable = false)
    @NotEmpty(message = "*Please provide a title")
    private String productName;

    @Column(name = "product_details")
    private String productDetails;

    public ProductsCategory() {
    }

    public ProductsCategory(Date createDate, Date modifiedDate, String productName, String productDetails) {
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.productName = productName;
        this.productDetails = productDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }
}
