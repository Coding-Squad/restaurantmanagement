package com.restaurant.management.rccui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Pranto on 21-Nov-17.
 */

@SpringUI(path = "/")
@Theme("valo")
public class home extends UI {

    private VerticalLayout verticalLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        setUplayout();
        addHeader();


    }

    private void setUplayout() {
        verticalLayout = new VerticalLayout();

        verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(verticalLayout);
    }

    private void addHeader() {
        Label header = new Label("Welcome to R C C");
        addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        verticalLayout.addComponent(header);
    }











}
