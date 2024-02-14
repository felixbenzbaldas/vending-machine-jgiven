package org.test;

import java.text.NumberFormat;
import java.util.Locale;

public class VendingMachine {
    int value = 0;

    public String getDisplay() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(value / 100.0);
    }

    public void insert(int value) {
        this.value += value;
    }
}
