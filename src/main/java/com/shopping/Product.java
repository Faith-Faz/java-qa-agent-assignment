package com.shopping;

public class Product {

    private String name;
    private double price;
    private int stockQuantity;

    public Product(String name, double price, int stockQuantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name must not be null or blank");
        }
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException("Product price must be a non-negative number");
        }
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Stock quantity must not be negative");
        }

        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
