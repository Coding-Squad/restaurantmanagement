package com.restaurant.management.rccui.users;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI(path = "/user")
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
        //addActionButton();
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
        VerticalLayout formLayout = new VerticalLayout();
        formLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        formLayout.setSpacing(true);
        formLayout.setWidth("70%");

        GridLayout userFormGridLayout = new GridLayout(8,8);
        userFormGridLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        userFormGridLayout.setSpacing(true);

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setSpacing(true);
        buttonLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);


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
        Button updateButton = new Button("Update");
        updateButton.setIcon(FontAwesome.EDIT);
        updateButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);

        buttonLayout.addComponents(addButton, updateButton);

        userFormGridLayout.addComponent(userNameLabel, 0,0);
        userFormGridLayout.addComponent(userName, 2,0);
        userFormGridLayout.addComponent(emailLabel, 0,1);
        userFormGridLayout.addComponent(email, 2,1);
        userFormGridLayout.addComponent(mobileNumberLabel, 0,2);
        userFormGridLayout.addComponent(mobileNumber, 2,2);
        userFormGridLayout.addComponent(passwordLabel, 0,3);
        userFormGridLayout.addComponent(password, 2,3);
        userFormGridLayout.addComponent(buttonLayout, 1,5);

        formLayout.addComponents(userFormGridLayout);
        verticalLayout.addComponent(formLayout);
    }

    private void addUsersList() {
        usersLists.setWidth("80%");
        verticalLayout.addComponent(usersLists);
    }

   /* private void addActionButton() {
        Button updateButton = new Button("Update");

        verticalLayout.addComponent(updateButton);
        updateButton.setIcon(FontAwesome.EDIT);
        updateButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
    }*/
}
