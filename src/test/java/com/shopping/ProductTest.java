package com.shopping;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldCreateProductWithCorrectDetails() {
        Product product = new Product("Laptop", 750.00, 10);

        assertEquals("Laptop", product.getName());
        assertEquals(750.00, product.getPrice());
        assertEquals(10, product.getStockQuantity());
    }

    @Test
    void shouldAllowZeroPriceAndZeroStock() {
        Product product = new Product("Free Sample", 0.00, 0);

        assertEquals(0.00, product.getPrice(), 0.001);
        assertEquals(0, product.getStockQuantity());
    }

    @Test
    void shouldRejectNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Product(null, 10.00, 1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void shouldRejectBlankName(String blankName) {
        assertThrows(IllegalArgumentException.class, () -> new Product(blankName, 10.00, 1));
    }

    @Test
    void shouldRejectNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Laptop", -0.01, 1));
    }

    @Test
    void shouldRejectNaNPrice() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Laptop", Double.NaN, 1));
    }

    @Test
    void shouldRejectNegativeStockQuantity() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Laptop", 10.00, -1));
    }
}
