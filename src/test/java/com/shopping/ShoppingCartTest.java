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

    @Test
    void shouldReturnZeroTotalForEmptyCart() {
        ShoppingCart cart = new ShoppingCart();

        assertEquals(0.00, cart.calculateTotal(), 0.001);
    }

    @Test
    void shouldRejectNullProduct() {
        ShoppingCart cart = new ShoppingCart();

        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> cart.addProduct(null));

        assertEquals("product must not be null", exception.getMessage());
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    void shouldLeaveCartUnchangedWhenRemovingProductNotInCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Keyboard", 50.00, 5));

        cart.removeProduct(new Product("Mouse", 25.00, 10));

        assertEquals(1, cart.getProducts().size());
        assertEquals(50.00, cart.calculateTotal(), 0.001);
    }

    @Test
    void shouldCountDuplicateProductsSeparately() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Keyboard", 50.00, 5);

        cart.addProduct(product);
        cart.addProduct(product);

        assertEquals(2, cart.getProducts().size());
        assertEquals(100.00, cart.calculateTotal(), 0.001);
    }

    @Test
    void shouldRemoveOnlyOneOccurrenceOfDuplicateProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Keyboard", 50.00, 5);
        cart.addProduct(product);
        cart.addProduct(product);

        cart.removeProduct(product);

        assertEquals(1, cart.getProducts().size());
    }

    @Test
    void shouldNotRemoveDifferentInstanceWithSameDetails() {
        // Documents current behaviour: Product has no equals(), so removal is by identity.
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Keyboard", 50.00, 5));

        cart.removeProduct(new Product("Keyboard", 50.00, 5));

        assertEquals(1, cart.getProducts().size());
    }

    @Test
    void shouldReturnUnmodifiableProductList() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Keyboard", 50.00, 5);
        cart.addProduct(product);

        assertThrows(UnsupportedOperationException.class,
                () -> cart.getProducts().add(new Product("Mouse", 25.00, 10)));
        assertThrows(UnsupportedOperationException.class,
                () -> cart.getProducts().remove(product));

        assertEquals(1, cart.getProducts().size());
    }
}
