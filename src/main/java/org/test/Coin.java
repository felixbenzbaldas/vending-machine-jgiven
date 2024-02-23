package org.test;

import java.util.Objects;

public class Coin {
    private final CoinType coinType;

    public Coin(CoinType coinType) {
        this.coinType = coinType;
    }

    public int getValue() {
        return coinType.getValue();
    }

    public CoinType getCoinType() {
        return coinType;
    }

    @Override
    public String toString() {
        return "a coin of type " + coinType.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return coinType == coin.coinType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coinType);
    }
}
