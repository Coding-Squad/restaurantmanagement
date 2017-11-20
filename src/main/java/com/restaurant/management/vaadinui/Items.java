package com.restaurant.management.vaadinui;

import com.vaadin.ui.VerticalLayout;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Component
@Entity
@Table(name="items")
public class Items  extends VerticalLayout{

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double price;


}
