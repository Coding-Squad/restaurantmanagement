package com.restaurant.management.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Programmer on 21-Nov-17.
 */

@Entity
@Table(name = "products")
public class Products {
    //>>>>>deafult value for bean
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_Id")
    private Long id;

    @Column(name = "user_Id", nullable = false)
    private Long userId;

    @Column(name = "create_Date" , nullable = false)
    private Date createDate;

    @Column(name = "modified_Date" , nullable = false)
    private Date modifiedDate ;

    //>>>>>>>>>deafult value for bean end

    @Column(name = "product_name", nullable = false)
    @NotEmpty(message = "*Please provide a title")
    private String productName;

    @Column(name = "product_details")
    private String details;

    @Column(name = "product_category_Id", nullable = false)
    private Long product_category_Id;


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public Long getProduct_category_Id() {
        return product_category_Id;
    }

    public void setProduct_category_Id(Long product_category_Id) {
        this.product_category_Id = product_category_Id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
}
