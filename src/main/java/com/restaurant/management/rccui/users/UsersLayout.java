package com.restaurant.management.rccui.users;

import com.restaurant.management.model.Users;
import com.vaadin.data.Binder;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Masum on 11/21/2017.
 */
public class UsersLayout extends HorizontalLayout {

    private final TextField  name;
    private final TextField  email;
    private final TextField  mobileNumber;

    public UsersLayout(Users allUsers) {
        setSpacing(true);
        name = new TextField();
        email = new TextField();
        mobileNumber = new TextField();
        name.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        email.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        mobileNumber.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);

        Binder<Users> usersBinder = new Binder<>(Users.class);
        usersBinder.bindInstanceFields(this);
        usersBinder.setBean(allUsers);

        addComponents(name, email, mobileNumber);
    }
}
