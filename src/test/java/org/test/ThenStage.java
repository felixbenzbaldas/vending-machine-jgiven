package org.test;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class ThenStage {

    @ExpectedScenarioState
    VendingMachine vendingMachine;

    @ExpectedScenarioState
    Display display;

    public void the_display_text_is(String display) {
        assertThat(vendingMachine.createCurrentDisplayText()).isEqualTo(display);
    }

    public void the_coin_return_contains(Coin coin) {
        assertThat(vendingMachine.getCoinReturn()).contains(coin);
    }

    public void the_coin_return_isEmpty() {
        assertThat(vendingMachine.getCoinReturn()).isEmpty();
    }

    public void the_display_text_is_set_to(String text) {
        verify(display).show(text);
    }
}
