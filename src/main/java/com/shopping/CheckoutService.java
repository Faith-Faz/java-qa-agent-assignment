package com.shopping;

import java.util.Objects;

public class CheckoutService {
    public double applyDiscount(double total, double discountPercentage){
        if (!Double.isFinite(total) || total < 0) {
            throw new IllegalArgumentException("Total must be a non-negative number");
        }
        if (Double.isNaN(discountPercentage) || discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }

        return total - (total*discountPercentage / 100);
    }

    public double checkout(ShoppingCart cart){
        Objects.requireNonNull(cart, "cart must not be null");
        return cart.calculateTotal();
    }
}
