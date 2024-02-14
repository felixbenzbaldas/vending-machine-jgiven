package org.test;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;

public class WhenStage {

    @ExpectedScenarioState
    VendingMachine vendingMachine;


    public void the_user_inserts(Coin coin) {
        vendingMachine.insert(coin);
    }
}
