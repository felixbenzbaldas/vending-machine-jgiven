package org.test;

public enum Product {
    COLA(100);

    private final int price;

    Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
