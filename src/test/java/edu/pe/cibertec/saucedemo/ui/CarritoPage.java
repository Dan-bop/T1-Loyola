package edu.pe.cibertec.saucedemo.ui;

public class CarritoPage {

    public static final String CART_BADGE =
            "[data-test='shopping-cart-badge']";

    public static final String CART_ICON =
            "[data-test='shopping-cart-link']";

    public static final String CART_ITEMS =
            "[data-test='inventory-item-name']";

    public static String addToCartButton(String productName) {
        String id = productName.toLowerCase().replace(" ", "-");
        return "[data-test='add-to-cart-" + id + "']";
    }

    public static String removeButton(String productName) {
        String id = productName.toLowerCase().replace(" ", "-");
        return "[data-test='remove-" + id + "']";
    }
}
