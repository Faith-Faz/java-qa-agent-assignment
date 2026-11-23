package com.shopping;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldCreateProductWithCorrectDetails() {
        Product product = new Product("Laptop", 750.00, 10);

        assertEquals("Laptop", product.getName());
        assertEquals(750.00, product.getPrice());
        assertEquals(10, product.getStockQuantity());
    }
}
