package com.restaurant.management.rccui.users;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI
@Theme("valo")
public class UsersUI extends UI{

    private VerticalLayout verticalLayout;

    @Autowired
    UsersLists usersLists;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setUplayout();
        addHeader();
        addForm();
        addUsersList();
        addActionButton();
    }

    private void setUplayout() {
        verticalLayout = new VerticalLayout();

        verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(verticalLayout);
    }

    private void addHeader() {
        Label header = new Label("Users");
        addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        verticalLayout.addComponent(header);
    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setSpacing(true);
        formLayout.setWidth("80%");
        Label userNameLabel = new Label("Name:");
        TextField userName = new TextField();
        Label emailLabel = new Label("Email:");
        TextField email = new TextField();
        Label mobileNumberLabel = new Label("Mobile Number:");
        TextField mobileNumber = new TextField();
        Label passwordLabel = new Label("Password:");
        TextField password = new TextField();
        Button addButton = new Button("Add User");
        addButton.setIcon(FontAwesome.PLUS);
        addButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
        formLayout.addComponents(userNameLabel, userName, emailLabel, email, mobileNumberLabel,mobileNumber,
               passwordLabel, password, addButton);
        verticalLayout.addComponent(formLayout);
    }

    private void addUsersList() {
        usersLists.setWidth("80%");
        verticalLayout.addComponent(usersLists);
    }

    private void addActionButton() {
        Button updateButton = new Button("Update");

        verticalLayout.addComponent(updateButton);
        updateButton.setIcon(FontAwesome.EDIT);
        updateButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
    }
}
