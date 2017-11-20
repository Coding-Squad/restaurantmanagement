package com.restaurant.management.vaadinui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Masum on 11/21/2017.
 */

@SpringUI
@Theme("valo")
public class VaadinUI extends UI{

    private VerticalLayout verticalLayout;

    @Autowired
    Items itemLists;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setUplayout();
        addHeader();
        addForm();
        addItemList();
        addActionButton();
    }

    private void setUplayout() {
        verticalLayout = new VerticalLayout();
        setContent(verticalLayout);
    }

    private void addHeader() {
        Label header = new Label("Menu Items");
        verticalLayout.addComponent(header);
    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        TextField itemName = new TextField();
        TextField itemPrice = new TextField();
        Button addButton = new Button("Add Items");
        formLayout.addComponents(itemName, itemPrice, addButton);
        verticalLayout.addComponent(formLayout);
    }

    private void addItemList() {
        verticalLayout.addComponent(itemLists);
    }

    private void addActionButton() {
        Button deleteButton = new Button("Delete Completed");

        verticalLayout.addComponent(deleteButton);
    }
}
