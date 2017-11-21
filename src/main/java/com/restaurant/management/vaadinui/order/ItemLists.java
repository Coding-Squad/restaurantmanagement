package com.restaurant.management.vaadinui.order;


import com.restaurant.management.model.Items;
import com.restaurant.management.repository.ItemsRepository;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class ItemLists extends VerticalLayout {

    @Autowired
    ItemsRepository itemsRepository;

    @PostConstruct
    void init(){
        setSpacing(true);

        setItems(itemsRepository.findAll());
    }

    private void setItems(List<Items> all) {
        removeAllComponents();

        all.forEach(allitem->{
            addComponent(new ItemsLayout(allitem));
        });
    }

}
