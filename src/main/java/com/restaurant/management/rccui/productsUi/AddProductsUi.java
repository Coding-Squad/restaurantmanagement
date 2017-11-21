package com.restaurant.management.rccui.productsUi;

import com.restaurant.management.model.Products;
import com.restaurant.management.model.ProductsCategory;
import com.restaurant.management.services.ProductCategoryService;
import com.restaurant.management.services.ProductService;
import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by Pranto on 21-Nov-17.
 */

@SpringUI(path = "/addProducts")
@Theme("valo")
public class AddProductsUi extends UI{


    private VerticalLayout verticalLayout;

    private GridLayout mainGridLayout;

    private ComboBox <ProductsCategory>           categoryComboBox;

    private TextField		 	productNameTextField;
    private TextArea		 	productDescriptionTextArea;

    private Button				sendButton;
    private Button				resetButton;

    Products products;

    @Autowired
    ProductCategoryService categoryService;

    @Autowired
    ProductService productService;

    Grid<Products> grid;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        grid = new Grid<>();
        setUplayout();
        addHeader();
        addForm();
        buttonLayout();
        loadAllProduct();

    }



    private void setUplayout() {
        verticalLayout = new VerticalLayout();

        verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(verticalLayout);
    }

    private void addHeader() {
        Label header = new Label("Add New Product");
        addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        verticalLayout.addComponent(header);
    }



    private void addForm() {

        mainGridLayout = new GridLayout(7, 3);
        mainGridLayout.setWidth("100%");
        mainGridLayout.setSpacing(true);
        mainGridLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        List<ProductsCategory> list = categoryService.getAllProductCategories();

        categoryComboBox = new ComboBox<> ();
        categoryComboBox.setPlaceholder("No category selected");

        categoryComboBox.setItems(list);

        categoryComboBox.setItemCaptionGenerator(p -> p.getProductName());



        productNameTextField = new TextField("Product Name");
        productNameTextField.setWidth("100%");
        productNameTextField.setRequiredIndicatorVisible(true);

        productDescriptionTextArea = new TextArea("Details");
        productDescriptionTextArea.setWidth("100%");

        mainGridLayout.addComponent(categoryComboBox,2,0,4,0);
        mainGridLayout.addComponent(productNameTextField,2,1,4,1);
        mainGridLayout.addComponent(productDescriptionTextArea,2,2,4,2);

        verticalLayout.addComponent(mainGridLayout);

    }


    private void buttonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setSpacing(true);

       			sendButton = new Button("Add");
       			sendButton.setIcon(VaadinIcons.PLUS);

       			sendButton = new Button("Add Product");
                sendButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

        sendButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
//Todo:


                    if (products == null) {
                        products = new Products();

                    }
                    //Todo: adding user Id here
                products.setUserId(Long.valueOf(100));

                products.setCreateDate(new Date());
                products.setModifiedDate(new Date());


                ProductsCategory productsCategory = (ProductsCategory) categoryComboBox.getValue();
                if (productsCategory != null) {
                    products.setProduct_category_Id(productsCategory.getId());
                }else {
                    Notification.show("Please select a Category Name", Notification.Type.ERROR_MESSAGE);
                    return;
                }

                    String name = productNameTextField.getValue().toString();
                    if (!name.equals(null) && !name.equals("")){
                        products.setProductName(name);
                    }else {
                        Notification.show("Please Enter product Name", Notification.Type.ERROR_MESSAGE);
                        return;
                    }

                    String details= productDescriptionTextArea.getValue().toString();
                    if (!details.equals(null) && !details.equals("")){
                        products.setDetails(details);
                    }

                productService.saveProduct(products);

                    Notification.show("Product Saved Successfully", Notification.Type.HUMANIZED_MESSAGE);

                    clearUi();
                    updateList();



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


        grid.addSelectionListener(selectionEvent -> {

            grid.addItemClickListener(event ->{

                if (event.getItem().getId() == 0) {
                    Notification.show("Please select a row !", Notification.Type.HUMANIZED_MESSAGE);
                }else{
                    products =productService.updateProduct(event.getItem().getId());
                }

                if (event.getItem().getProductName() != null){
                    productNameTextField.setValue(event.getItem().getProductName());
                }else{
                    productNameTextField.setValue("");
                }
                if (event.getItem().getDetails() != null){
                    productDescriptionTextArea.setValue(event.getItem().getDetails());
                }else{
                    productDescriptionTextArea.setValue("");
                }


            });

        });

        buttonLayout.addComponents(sendButton,resetButton);
        verticalLayout.addComponent(buttonLayout);


    }


    public void clearUi() {
        //TODO Clear Claim Category .

        products = null;
        categoryComboBox.setValue(null);
        productNameTextField.setValue("");
        productDescriptionTextArea.setValue("");
    }

    public void updateList(){
        List<Products> allProducts= productService.getAllProducts();
        grid.setItems(allProducts);
    }

    private void loadAllProduct() {
        // Create a grid bound to the list
        updateList();

        grid.addColumn(Products::getProductName).setCaption("Product Name");
        grid.addColumn(Products::getDetails).setCaption("Details");

        verticalLayout.addComponent(grid);

    }

}
