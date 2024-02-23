package org.test;

import com.tngtech.jgiven.annotation.FillerWord;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class GivenStage {


    @ProvidedScenarioState
    VendingMachine vendingMachine;

    public GivenStage a_vending_machine() {
        vendingMachine = new VendingMachine();
        return this;
    }

    @FillerWord
    GivenStage and() {
        return this;
    }
}
