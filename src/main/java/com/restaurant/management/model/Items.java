package com.restaurant.management.model;



import javax.persistence.*;

@Entity
@Table(name="items")
public class Items{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="itemName")
    private String name;

    @Column(name="itemPrice")
    private double price;

    public Items() {
    }

    public Items(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
