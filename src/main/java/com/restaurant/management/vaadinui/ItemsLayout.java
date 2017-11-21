package com.restaurant.management.vaadinui;

import com.vaadin.data.Binder;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Masum on 11/21/2017.
 */
public class ItemsLayout extends HorizontalLayout {

    private final TextField  name;
    private final TextField  price;

    public ItemsLayout(Items allitem) {
        setSpacing(true);
        name = new TextField();
        price = new TextField();
        name.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        price.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);

        Binder<Items> itemBinder = new Binder<>(Items.class);
        itemBinder.bindInstanceFields(this);
        itemBinder.setBean(allitem);

        addComponents(name, price);
    }
}
