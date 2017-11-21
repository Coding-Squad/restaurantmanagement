package com.restaurant.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Programmer on 21-Nov-17.
 */

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_Id")
    private Long id;

    @Column(name = "product_name", nullable = false)
    @NotEmpty(message = "*Please provide a title")
    private String productName;

    @Column(name = "user_Id", nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Date createDate = new Date();

    @Column(nullable = false)
    private Date modifiedDate ;

    @Column(nullable = false)
    private Date expireDate;




}
