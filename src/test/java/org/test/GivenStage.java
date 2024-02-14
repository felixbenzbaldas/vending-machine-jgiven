package org.test;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class GivenStage {


    @ProvidedScenarioState
    VendingMachine vendingMachine;

    public void a_vending_machine() {
        vendingMachine = new VendingMachine();
    }
}
