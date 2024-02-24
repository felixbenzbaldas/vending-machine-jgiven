package org.test;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ThenStage {

    @ExpectedScenarioState
    VendingMachine vendingMachine;

    @ExpectedScenarioState
    Display display;

    @ExpectedScenarioState
    CoinReturn coinReturn;

    @ExpectedScenarioState
    Shelf shelf;

    public void the_display_text_is(String display) {
        assertThat(vendingMachine.createCurrentDisplayText()).isEqualTo(display);
    }

    public void the_vending_machine_will_return_no_coin() {
        verify(coinReturn, never()).add(any());
    }

    public void $_is_added_to_the_coin_return(Coin coin) {
        verify(coinReturn).add(coin);
    }

    public void the_display_text_is_set_to(String text) {
        verify(display).show(text);
    }

    public void $_is_added_to_the_shelf(Product product) {
        verify(shelf).addProduct(product);
    }
}
