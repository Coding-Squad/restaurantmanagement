package com.restaurant.management.rccui.productsUi;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Pranto on 21-Nov-17.
 */

@SpringUI(path = "/addProducts")
@Theme("valo")
public class AddProductsUi extends UI{


    private VerticalLayout verticalLayout;

    private GridLayout mainGridLayout;

    private TextField		 	productNameTextField;
    private TextArea		 	productDescriptionTextArea;

    private Button				sendButton;
    private Button				editButton;
    private Button				resetButton;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setUplayout();
        addHeader();
        addForm();
        buttonLayout();

    }



    private void setUplayout() {
        verticalLayout = new VerticalLayout();

        verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(verticalLayout);
    }

    private void addHeader() {
        Label header = new Label("Add New Product");
        addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        verticalLayout.addComponent(header);
    }



    private void addForm() {

        mainGridLayout = new GridLayout(7, 2);
        mainGridLayout.setWidth("100%");
        mainGridLayout.setSpacing(true);
        mainGridLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        productNameTextField = new TextField("Product Name");
        productNameTextField.setWidth("100%");
        productNameTextField.setRequiredIndicatorVisible(true);

        productDescriptionTextArea = new TextArea("Details");
        productDescriptionTextArea.setWidth("100%");

        mainGridLayout.addComponent(productNameTextField,2,0,4,0);
        mainGridLayout.addComponent(productDescriptionTextArea,2,1,4,1);

        verticalLayout.addComponent(mainGridLayout);

    }


    private void buttonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
       			sendButton = new Button("Add Product");
                sendButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

       			editButton= new Button("Edit ");
        		resetButton= new Button("Clear");

        buttonLayout.addComponents(sendButton,editButton,resetButton);
        verticalLayout.addComponent(buttonLayout);


    }







}
