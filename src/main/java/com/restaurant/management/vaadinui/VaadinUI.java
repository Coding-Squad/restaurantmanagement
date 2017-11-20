package com.restaurant.management.vaadinui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
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
        verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(verticalLayout);
    }

    private void addHeader() {
        Label header = new Label("Menu Items");
        addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        verticalLayout.addComponent(header);
    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setSpacing(true);
        formLayout.setWidth("80%");
        Label itemNameLabel = new Label("Name:");
        TextField itemName = new TextField();
        Label itemPriceLabel = new Label("Price:");
        TextField itemPrice = new TextField();
        Button addButton = new Button("Add Items");
        addButton.setIcon(FontAwesome.PLUS);
        addButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
        formLayout.addComponents(itemNameLabel, itemName, itemPriceLabel, itemPrice, addButton);
        verticalLayout.addComponent(formLayout);
    }

    private void addItemList() {
        itemLists.setWidth("80%");
        verticalLayout.addComponent(itemLists);
    }

    private void addActionButton() {
        Button deleteButton = new Button("Delete");

        verticalLayout.addComponent(deleteButton);
        deleteButton.setIcon(FontAwesome.MINUS);
        deleteButton.setStyleName(ValoTheme.BUTTON_DANGER);
    }
}
