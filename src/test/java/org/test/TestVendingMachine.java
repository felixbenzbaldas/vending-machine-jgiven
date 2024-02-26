package org.test;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

public class TestVendingMachine extends ScenarioTest<GivenStage, WhenStage, ThenStage> {

    @Test
    void test_initial_display() {
        given().a_vending_machine();
        then().the_display_text_is("INSERT COIN");
    }

    @Test
    void test_display_text_after_inserting_a_coin() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.NICKEL));
        then().the_display_text_is("$0.05");
    }

    @Test
    void should_update_display() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.NICKEL));
        then().the_display_text_is_set_to("$0.05");
    }

    @Test
    void should_reject_invalid_coins() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.PENNY));
        then().$_is_added_to_the_coin_return(new Coin(CoinType.PENNY));
    }

    @Test
    void test_coin_return_after_inserting_valid_coin() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.NICKEL));
        then().the_vending_machine_will_return_no_coin();
    }

    @Test
    void test_addition_of_different_coins() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.DIME));
        then().the_display_text_is("$0.35");
    }

    @Test
    void test_not_enough_money() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_presses_the_button_for(Product.COLA);
        then().the_display_text_is("PRICE $1.00");
    }

    @Test
    void test_add_product_to_shelf() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_presses_the_button_for(Product.COLA);
        then().$_is_added_to_the_shelf(Product.COLA);
    }

    @Test
    void should_display_THANK_YOU_after_purchase() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_presses_the_button_for(Product.COLA);
        then().the_display_text_is_set_to("THANK YOU");
    }

    @Test
    void should_return_rest() { // TODO: only return money when user presses the return coins button
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.DIME))
                .and().the_user_inserts(new Coin(CoinType.DIME))
                .and().the_user_inserts(new Coin(CoinType.DIME))
                .and().the_user_presses_the_button_for(Product.COLA);
        then().$_is_added_to_the_coin_return(new Coin(CoinType.NICKEL));
    }

    @Test
    void test_4999_milliseconds_after_purchase() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_presses_the_button_for(Product.COLA)
                .and().$_milliseconds_passed(4999);
        then().the_display_text_is_set_to("THANK YOU");
    }

    @Test
    void test_five_seconds_after_purchase() {
        given().a_vending_machine();
        when().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_inserts(new Coin(CoinType.QUARTER))
                .and().the_user_presses_the_button_for(Product.COLA)
                .and().$_milliseconds_passed(5000);
        then().the_display_text_is_set_to("INSERT COIN");
    }
}