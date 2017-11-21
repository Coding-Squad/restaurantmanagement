package com.restaurant.management.rccui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Programmer on 21-Nov-17.
 */
@SpringUI(path = "/login")
@Theme("valo")
public class Login extends UI{

    private VerticalLayout verticalLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        setUplayout();
        addHeader();
        addForm();


    }

    private void addForm() {

        GridLayout formLayout = new GridLayout(9,9);
        formLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        formLayout.setSpacing(true);
        formLayout.setWidth("70%");

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        buttonLayout.setSpacing(true);
        buttonLayout.setWidth("50%");

        Label userEmailLabel = new Label("User Email");
        TextField userEmail = new TextField();
        userEmail.setPlaceholder("Email");
        Label userPasswordLabel = new Label("Password");
        TextField userPassword = new TextField();
        userPassword.setPlaceholder("Password");
        Button loginButton = new Button("Login");
        loginButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        loginButton.setIcon(FontAwesome.LOCK);

        formLayout.addComponent(userEmailLabel, 3,5);
        formLayout.addComponent(userEmail, 4,5);
        formLayout.addComponent(userPasswordLabel, 3,6);
        formLayout.addComponent(userPassword, 4,6);
        formLayout.addComponent(buttonLayout, 4,7);
        buttonLayout.addComponent(loginButton);
        verticalLayout.addComponents(formLayout);

    }

    private void setUplayout() {
        verticalLayout = new VerticalLayout();

        verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(verticalLayout);
    }

    private void addHeader() {
        Label header = new Label("Login into RCC Management");
        addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        verticalLayout.addComponent(header);
    }
}
