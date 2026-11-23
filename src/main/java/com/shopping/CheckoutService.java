package com.shopping;

public class CheckoutService {
    public double applyDiscount(double total, double discountPercentage){
        return total - (total*discountPercentage / 100);
    }

    public double checkout(ShoppingCart cart){
        return cart.calculateTotal();
    }
}
