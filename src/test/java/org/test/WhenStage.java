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
}
