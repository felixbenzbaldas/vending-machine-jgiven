package org.test;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

public class TestVendingMachine extends ScenarioTest<GivenStage, WhenStage, ThenStage> {

    @Test
    void should_update_display() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.NICKEL));
        then().the_vending_machine_displays("$0.05");
    }

    @Test
    void should_reject_invalid_coins() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.PENNY));
        then().the_coin_return_contains(new Coin(CoinType.PENNY));
    }

    @Test
    void test_coin_return_stays_empty() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.NICKEL));
        then().the_coin_return_isEmpty();
    }

    @Test
    void test_addition_of_different_coins() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.DIME));
        then().the_vending_machine_displays("$0.35");
    }

}