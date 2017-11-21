package com.restaurant.management.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Pranto on 21-Nov-17.
 */

@Entity
@Table(name = "products_details")
public class ProductsDetails {

    //>>>>>deafult value for bean
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_details_Id")
    private Long id;

    @Column(name = "user_Id", nullable = false)
    private Long userId;

    @Column(name = "create_Date" , nullable = false)
    private Date createDate;

    @Column(name = "modified_Date" , nullable = false)
    private Date modifiedDate ;

    //>>>>>>>>>deafult value for bean end

    @Column(name = "product_Id", nullable = false)
    private Long productId;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "expired_Date" , nullable = false)
    private Date expiredDate ;


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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

}
