package org.test;

import java.text.NumberFormat;
import java.util.Locale;

public class VendingMachine {
    int value = 0;
    State state = State.DEFAULT;
    Product selectedProduct;
    private Display display;

    private CoinReturn coinReturn;

    VendingMachine(Display display, CoinReturn coinReturn) {
        this.display = display;
        this.coinReturn = coinReturn;
    }

    public String createCurrentDisplayText() {
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

    public void selectProduct(Product product) {
        if (value < product.getPrice()) {
            state = State.SHOW_PRICE;
            selectedProduct = product;
        }
    }

    private void updateDisplay() {
        display.show(createCurrentDisplayText());
    }
}
