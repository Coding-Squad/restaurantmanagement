package com.restaurant.management.rccui.productsUi;


import com.restaurant.management.model.ProductsCategory;
import com.restaurant.management.services.ProductCategoryService;
import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.components.grid.MultiSelectionModel;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by Pranto on 21-Nov-17.
 */
@SpringUI(path = "/addProductsCategory")
@Theme("valo")
public class productCategoryUi extends UI{

    private VerticalLayout verticalLayout;
    private GridLayout mainGridLayout;
    private TextField categoryNameTextField;
    private TextArea categoryDescriptionTextArea;

    Grid<ProductsCategory> grid = new Grid<>();

    private Button				sendButton;
    private Button				editButton;
    private Button				resetButton;



    @Autowired
    ProductCategoryService categoryService;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        setUplayout();
        addHeader();
        addForm();
        buttonLayout();
        loadAllCategory();

    }



    private void setUplayout() {
        verticalLayout = new VerticalLayout();

        verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(verticalLayout);
    }

    private void addHeader() {
        Label header = new Label("Add New Product Category");
        addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        verticalLayout.addComponent(header);
    }


    private void addForm() {

        mainGridLayout = new GridLayout(7, 2);
        mainGridLayout.setWidth("100%");
        mainGridLayout.setSpacing(true);
        mainGridLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        categoryNameTextField = new TextField("Product Category Name");
        categoryNameTextField.setWidth("100%");
        categoryNameTextField.setRequiredIndicatorVisible(true);

        categoryDescriptionTextArea = new TextArea("Details");
        categoryDescriptionTextArea.setWidth("100%");

        mainGridLayout.addComponent(categoryNameTextField,2,0,4,0);
        mainGridLayout.addComponent(categoryDescriptionTextArea,2,1,4,1);

        verticalLayout.addComponent(mainGridLayout);

    }


    private void buttonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        sendButton = new Button(" Add");
        sendButton.setIcon(VaadinIcons.PLUS);
        sendButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

        sendButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                ProductsCategory productsCategory = new ProductsCategory();

                productsCategory.setUserId(Long.valueOf(100));
                productsCategory.setCreateDate(new Date());
                productsCategory.setModifiedDate(new Date());

                String name = categoryNameTextField.getValue().toString();
                if (!name.equals(null) && !name.equals("")){
                    productsCategory.setProductName(name);
                }else {
                    Notification.show("Please Enter Category Name", Notification.Type.ERROR_MESSAGE);
                    return;
                }

                String details= categoryDescriptionTextArea.getValue().toString();
                if (!details.equals(null) && !details.equals("")){
                    productsCategory.setProductDetails(details);
                }

                categoryService.saveProductCategory(productsCategory);

                Notification.show("Category Saved Successfully", Notification.Type.HUMANIZED_MESSAGE);

                clearUi();
                updateList();


            }
        });

        editButton= new Button("Edit");
        editButton.setIcon(VaadinIcons.EDIT);
        editButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

        editButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                grid.addSelectionListener(selectionEvent -> {

                    grid.addItemClickListener(event ->{

                        categoryNameTextField.setValue(event.getItem().getProductName());
                        categoryDescriptionTextArea.setValue(event.getItem().getProductDetails());
                            });



                });
            }
        });

        resetButton= new Button("Clear");
        resetButton.setIcon(VaadinIcons.REFRESH);
        resetButton.addStyleName(ValoTheme.BUTTON_DANGER);

        resetButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                clearUi();
            }
        });

        buttonLayout.addComponents(sendButton,editButton,resetButton);
        verticalLayout.addComponent(buttonLayout);


    }



    public void clearUi() {
        //TODO Clear Claim Category .

        categoryNameTextField.setValue("");
        categoryDescriptionTextArea.setValue("");
         }



    private void loadAllCategory() {
        // Create a grid bound to the list
        updateList();
        grid.addColumn(ProductsCategory::getProductName).setCaption("Product Name");
        grid.addColumn(ProductsCategory::getProductDetails).setCaption("Details");

        verticalLayout.addComponent(grid);


    }

    public void updateList(){
        List<ProductsCategory> allProductCategories= categoryService.getAllProductCategories();
        grid.setItems(allProductCategories);
    }

}
