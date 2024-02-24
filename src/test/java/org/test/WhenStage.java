package org.test;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.FillerWord;
import org.mockito.ArgumentCaptor;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

public class WhenStage {

    @ExpectedScenarioState
    VendingMachine vendingMachine;

    @ExpectedScenarioState
    Timer timer;


    public WhenStage the_user_inserts(Coin coin) {
        vendingMachine.insert(coin);
        return this;
    }

    @FillerWord
    WhenStage and() {
        return this;
    }

    public WhenStage the_user_presses_the_button_for(Product product) {
        vendingMachine.selectProduct(product);
        return this;
    }

    public void five_seconds_pass() {
        ArgumentCaptor<Runnable> argument = ArgumentCaptor.forClass(Runnable.class);
        verify(timer).runLater(argument.capture(), eq(5000L));
        argument.getValue().run();
    }
}
