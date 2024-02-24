package org.test;

import java.text.NumberFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class VendingMachine {
    int valueInserted = 0;
    State state = State.DEFAULT;
    Product selectedProduct;
    private Display display;

    private CoinReturn coinReturn;

    private Shelf shelf;

    VendingMachine(Display display, CoinReturn coinReturn, Shelf shelf) {
        this.display = display;
        this.coinReturn = coinReturn;
        this.shelf = shelf;
    }

    public String createCurrentDisplayText() {
        if (state == State.SHOW_PRICE) {
            return "PRICE " + NumberFormat.getCurrencyInstance(Locale.US).format(selectedProduct.getPrice() / 100.0);
        }
        if (valueInserted == 0) {
            return "INSERT COIN";
        }
        return NumberFormat.getCurrencyInstance(Locale.US).format(valueInserted / 100.0);
    }

    public void insert(Coin coin) {
        if (coin.getCoinType() == CoinType.PENNY) {
            coinReturn.add(coin);
            return;
        }
        this.valueInserted += coin.getValue();
        this.updateDisplay();
    }

    public void selectProduct(Product product) {
        if (valueInserted < product.getPrice()) {
            state = State.SHOW_PRICE;
            selectedProduct = product;
        } else {
            shelf.addProduct(product);
            display.show("THANK YOU");
            int rest = valueInserted - product.getPrice();
            getCoinsForValue(rest).forEach(coinReturn::add);
        }
    }

    private void updateDisplay() {
        display.show(createCurrentDisplayText());
    }

    private Set<Coin> getCoinsForValue(int value) {
        Set<Coin> coins = new HashSet<>();
        List<CoinType> coinTypesInDescendingOrder = List.of(CoinType.QUARTER, CoinType.DIME, CoinType.NICKEL);
        for (CoinType coinType : coinTypesInDescendingOrder) {
            while (value >= coinType.getValue()) {
                coins.add(new Coin(coinType));
                value -= coinType.getValue();
            }
        }
        return coins;
    }
}
