package com.shopping;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    void shouldReturnOriginalTotalWhenDiscountIsZeroPercent() {
        CheckoutService service = new CheckoutService();

        assertEquals(100.00, service.applyDiscount(100.00, 0), 0.001);
    }

    @Test
    void shouldReturnZeroWhenDiscountIsOneHundredPercent() {
        CheckoutService service = new CheckoutService();

        assertEquals(0.00, service.applyDiscount(100.00, 100), 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.01, -10, 100.01, 150})
    void shouldRejectDiscountOutsideZeroToOneHundred(double invalidDiscount) {
        CheckoutService service = new CheckoutService();

        assertThrows(IllegalArgumentException.class,
                () -> service.applyDiscount(100.00, invalidDiscount));
    }

    @Test
    void shouldRejectNaNDiscount() {
        CheckoutService service = new CheckoutService();

        assertThrows(IllegalArgumentException.class,
                () -> service.applyDiscount(100.00, Double.NaN));
    }

    @Test
    void shouldRejectNegativeTotalWhenApplyingDiscount() {
        CheckoutService service = new CheckoutService();

        assertThrows(IllegalArgumentException.class,
                () -> service.applyDiscount(-50.00, 10));
    }

    @Test
    void shouldReturnZeroWhenCheckingOutEmptyCart() {
        CheckoutService service = new CheckoutService();

        assertEquals(0.00, service.checkout(new ShoppingCart()), 0.001);
    }

    @Test
    void shouldRejectNullCartAtCheckout() {
        CheckoutService service = new CheckoutService();

        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> service.checkout(null));

        assertEquals("cart must not be null", exception.getMessage());
    }

    @Test
    void shouldApplyDiscountToCartTotal() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Keyboard", 100.00, 5));
        cart.addProduct(new Product("Mouse", 50.00, 10));
        CheckoutService service = new CheckoutService();

        double discounted = service.applyDiscount(service.checkout(cart), 20);

        assertEquals(120.00, discounted, 0.001);
    }
}
