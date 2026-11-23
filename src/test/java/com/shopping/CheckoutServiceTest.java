package com.shopping;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheckoutServiceTest {

    @Test
    void shouldApplyTenPercentDiscount() {
        CheckoutService service = new CheckoutService();

        double result = service.applyDiscount(100.00, 10);

        assertEquals(90.00, result, 0.001);
    }

    @Test
    void shouldCheckoutShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 750.00, 2));

        CheckoutService service = new CheckoutService();

        assertEquals(750.00, service.checkout(cart), 0.001);
    }
}
