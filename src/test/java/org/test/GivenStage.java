package org.test;

import static org.mockito.Mockito.mock;

import com.tngtech.jgiven.annotation.FillerWord;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class GivenStage {


    @ProvidedScenarioState
    VendingMachine vendingMachine;

    @ProvidedScenarioState
    Display display = mock(Display.class);
    @ProvidedScenarioState
    CoinReturn coinReturn = mock(CoinReturn.class);

    @ProvidedScenarioState
    Shelf shelf = mock(Shelf.class);

    @ProvidedScenarioState
    Timer timer = mock(Timer.class);

    public GivenStage a_vending_machine() {
        vendingMachine = new VendingMachine(display, coinReturn, shelf, timer);
        return this;
    }

    @FillerWord
    GivenStage and() {
        return this;
    }
}
