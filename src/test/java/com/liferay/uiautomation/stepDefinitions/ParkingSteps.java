package com.liferay.uiautomation.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingSteps extends PageLoader {

    @Given("the parking cost calculator system")
    public void the_parking_cost_calculator_system() {
        String baseUrl = "http://www.shino.de/parkcalc";
        driver.get(baseUrl);
    }

    @When("the user selects the {string} rate")
    public void the_user_selects_the_rate(String parkingLot) {
        parkingCostCalculator.selectParkingLot(parkingLot);
    }

    @And("the user starts the parking at {string} and {string} and sets {string}")
    public void the_user_starts_the_parking_at_and_and_sets(String startingDate, String startingTime, String startingAMPM) {
        parkingCostCalculator.using(driver)
                .setStartingDate(startingDate)
                .setStartingTime(startingTime)
                .setStartingAMPM(startingAMPM);
    }

    @And("the user closes the parking at {string} and {string} and sets {string}")
    public void the_user_closes_the_parking_at_and_and_sets(String leavingDate, String leavingTime, String leavingAMPM) {
        parkingCostCalculator.setLeavingDate(leavingDate)
                .setLeavingTime(leavingTime)
                .setLeavingAMPM(leavingAMPM)
                .submit();
    }

    @Then("the system estimates the {string} ticket price")
    public void the_system_estimates_the_ticket_price(String expectedCalculatedCost) {
        assertThat(parkingCostCalculator.getCalculatedCost(), is(expectedCalculatedCost));
    }

    @Then("the system displays a the following {string} in the price cell")
    public void the_system_displays_a_the_following_in_the_price_cell(String warning) {
        assertThat(parkingCostCalculator.getWarning().toLowerCase(), equalTo(warning.toLowerCase()));
    }

}
