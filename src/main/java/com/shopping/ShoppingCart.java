package com.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        Objects.requireNonNull(product, "product must not be null");
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double calculateTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }

        return total;
    }

    public List<Product> getProducts() {
        return List.copyOf(products);
    }
}
