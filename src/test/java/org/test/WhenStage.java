package org.test;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.FillerWord;

public class WhenStage {

    @ExpectedScenarioState
    VendingMachine vendingMachine;


    public WhenStage the_user_inserts(Coin coin) {
        vendingMachine.insert(coin);
        return this;
    }

    @FillerWord
    WhenStage and() {
        return this;
    }

    public void the_user_presses_the_button_for(Product product) {
        vendingMachine.selectProduct(product);
    }
}
