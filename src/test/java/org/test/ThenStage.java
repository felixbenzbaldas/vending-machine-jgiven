package org.test;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.mockito.ArgumentCaptor;

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
        ArgumentCaptor<String> textCaptor = ArgumentCaptor.forClass(String.class);
        verify(display, atLeastOnce()).show(textCaptor.capture());
        assertThat(textCaptor.getValue()).isEqualTo(text); // getValue() gets the last value captured
    }

    public void $_is_added_to_the_shelf(Product product) {
        verify(shelf).addProduct(product);
    }
}
