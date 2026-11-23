package com.shopping;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void shouldAddProductToCart() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Keyboard", 50.00, 5);

        cart.addProduct(product);

        assertEquals(1, cart.getProducts().size());
    }

    @Test
    void shouldCalculateTotalCorrectly() {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Keyboard", 50.00, 5));
        cart.addProduct(new Product("Mouse", 25.00, 10));

        assertEquals(75.00, cart.calculateTotal(), 0.001);
    }

    @Test
    void shouldRemoveProductFromCart() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Keyboard", 50.00, 5);

        cart.addProduct(product);
        cart.removeProduct(product);

        assertEquals(0, cart.getProducts().size());
    }
}
