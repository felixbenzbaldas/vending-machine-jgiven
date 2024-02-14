package org.test;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.*;

public class ThenStage {

    @ExpectedScenarioState
    VendingMachine vendingMachine;

    public void the_vending_machine_displays(String display) {
        assertThat(vendingMachine.getDisplay()).isEqualTo(display);
    }

    public void the_coin_return_contains(Coin coin) {
        assertThat(vendingMachine.getCoinReturn()).contains(coin);
    }

    public void the_coin_return_isEmpty() {
        assertThat(vendingMachine.getCoinReturn()).isEmpty();
    }
}
