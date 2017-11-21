package com.restaurant.management.rccui.users;

import com.restaurant.management.model.Users;
import com.restaurant.management.services.UserService;
import com.vaadin.annotations.Theme;
import com.vaadin.event.MouseEvents;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Registration;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI(path = "/user")
@Theme("valo")
public class UsersUI extends UI{

    private VerticalLayout verticalLayout;

    private Button addButton;

    private Button updateButton;

    @Autowired
    UsersLists usersLists;

    @Autowired
    UserService userService;


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

        GridLayout userFormGridLayout = new GridLayout(9,9);
        userFormGridLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        userFormGridLayout.setSpacing(true);

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setSpacing(true);
        buttonLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);


        Label userFirstNameLabel = new Label("First Name:");
        TextField userFirstName = new TextField();
        Label userLasttNameLabel = new Label("Last Name:");
        TextField userLastName = new TextField();
        Label emailLabel = new Label("Email:");
        TextField email = new TextField();
        Label mobileNumberLabel = new Label("Mobile Number:");
        TextField mobileNumber = new TextField();
        Label passwordLabel = new Label("Password:");
        TextField password = new TextField();
        addButton = new Button("Add User");
        addButton.setIcon(FontAwesome.PLUS);
        addButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
        updateButton = new Button("Update");
        updateButton.setIcon(FontAwesome.EDIT);
        updateButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);

        buttonLayout.addComponents(addButton, updateButton);

        addButton.addClickListener(clickEvent -> {
            Users user = new Users();

            String firstName = userFirstName.getValue().toString();
            String lastName = userLastName.getValue().toString();
            String userEmail = email.getValue().toString();
            String userMobile = mobileNumber.getValue().toString();
            String userPassword = password.getValue().toString();
            if(firstName!="" || lastName!="" || userEmail!="" || userMobile!="" || userPassword!="" ){
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(userEmail);
            user.setMobileNumber(userMobile);
            user.setPassword(userPassword);
            System.out.println("User Detail_______"+user);
            userService.saveUser(user);
            Notification.show("User Saved Successfully", Notification.Type.HUMANIZED_MESSAGE);
            }else{
                Notification.show("Please Fill All Fields", Notification.Type.ERROR_MESSAGE);
            }
        });



        userFormGridLayout.addComponent(userFirstNameLabel, 0,1);
        userFormGridLayout.addComponent(userFirstName, 2,1);
        userFormGridLayout.addComponent(userLasttNameLabel, 0,2);
        userFormGridLayout.addComponent(userLastName, 2,2);
        userFormGridLayout.addComponent(emailLabel, 0,3);
        userFormGridLayout.addComponent(email, 2,3);
        userFormGridLayout.addComponent(mobileNumberLabel, 0,4);
        userFormGridLayout.addComponent(mobileNumber, 2,4);
        userFormGridLayout.addComponent(passwordLabel, 0,5);
        userFormGridLayout.addComponent(password, 2,5);
        //userFormGridLayout.addComponent(addButton, 2,5);
        //userFormGridLayout.addComponent(updateButton, 3,5);

        formLayout.addComponents(userFormGridLayout);
        verticalLayout.addComponent(formLayout);
        verticalLayout.addComponent(buttonLayout);
    }



    private void addUsersList() {
        usersLists.setWidth("100%");
        verticalLayout.addComponent(usersLists);
    }


    /* private void addActionButton() {
        Button updateButton = new Button("Update");

        verticalLayout.addComponent(updateButton);
        updateButton.setIcon(FontAwesome.EDIT);
        updateButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
    }*/
}
