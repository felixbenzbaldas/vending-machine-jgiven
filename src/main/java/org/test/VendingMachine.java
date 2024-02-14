package org.test;

import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class VendingMachine {
    int value = 0;
    Set<Coin> coinReturn = new HashSet<>();

    public String getDisplay() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(value / 100.0);
    }

    public void insert(Coin coin) {
        if (coin.getCoinType() == CoinType.PENNY) {
            coinReturn.add(coin);
            return;
        }
        this.value += coin.getValue();
    }

    public Set<Coin> getCoinReturn() {
        return coinReturn;
    }
}
