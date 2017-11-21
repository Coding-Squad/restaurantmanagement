package com.restaurant.management.rccui.users;


import com.restaurant.management.model.Users;
import com.restaurant.management.repository.UsersRepository;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class UsersLists extends VerticalLayout {

    @Autowired
    UsersRepository usersRepository;

    @PostConstruct
    void init(){
        setSpacing(true);

        setUsers(usersRepository.findAll());
    }

    private void setUsers(List<Users> allUsers) {
        removeAllComponents();

        allUsers.forEach(allUser->{
            addComponent(new UsersLayout(allUser));
        });
    }

}
