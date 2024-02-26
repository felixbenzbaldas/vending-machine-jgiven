package org.test;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.FillerWord;
import org.mockito.ArgumentCaptor;

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

    public void $_milliseconds_passed(long milliseconds) {
        ArgumentCaptor<Runnable> runnableCapture = ArgumentCaptor.forClass(Runnable.class);
        ArgumentCaptor<Long> timeCapture = ArgumentCaptor.forClass(Long.class);
        verify(timer).runLater(runnableCapture.capture(), timeCapture.capture());
        for (int i = 0; i < runnableCapture.getAllValues().size(); i++) {
            if (milliseconds >= timeCapture.getAllValues().get(i)) {
                runnableCapture.getAllValues().get(i).run();
            }
        }
    }
}
