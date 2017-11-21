package com.restaurant.management.model;

import javax.persistence.*;

/**
 * Created by Programmer on 21-Nov-17.
 */

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
