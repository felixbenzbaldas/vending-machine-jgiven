package org.test;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

public class TestVendingMachine extends ScenarioTest<GivenStage, WhenStage, ThenStage> {

    @Test
    void should_update_display() {
        given().a_vending_machine();
        when().the_user_inserts(5);
        then().the_vending_machine_displays("$0.05");
    }
}