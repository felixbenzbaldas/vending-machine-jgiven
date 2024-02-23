package org.test;

import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class VendingMachine {
    int value = 0;
    State state = State.DEFAULT;
    Set<Coin> coinReturn = new HashSet<>();
    Product selectedProduct;
    private Display display;

    VendingMachine(Display display) {
        this.display = display;
    }

    public String getDisplay() {
        if (state == State.SHOW_PRICE) {
            return "PRICE " + NumberFormat.getCurrencyInstance(Locale.US).format(selectedProduct.getPrice() / 100.0);
        }
        if (value == 0) {
            return "INSERT COIN";
        }
        return NumberFormat.getCurrencyInstance(Locale.US).format(value / 100.0);
    }

    public void insert(Coin coin) {
        if (coin.getCoinType() == CoinType.PENNY) {
            coinReturn.add(coin);
            return;
        }
        this.value += coin.getValue();
        this.updateDisplay();
    }

    public Set<Coin> getCoinReturn() {
        return coinReturn;
    }

    public void selectProduct(Product product) {
        if (value < product.getPrice()) {
            state = State.SHOW_PRICE;
            selectedProduct = product;
        }
    }

    private void updateDisplay() {
        display.show(getDisplay());
    }
}
