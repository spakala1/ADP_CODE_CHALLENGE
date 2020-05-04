package com.automatedtest.sample.homepage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AutoTraderSteps {


    private AutoTrader autoTrader;

    public AutoTraderSteps() {
        autoTrader = new AutoTrader();
    }

    @When("^I login to Auto trader web page$")
    public void login_To_Auto_Trader_Web_Page() {
        autoTrader.goToHomePage();
    }

    @Then("^I verify \"([^\"]*)\" is displayed on Auto Trader page$")
    public void verify_is_displayed_on_auto_trader_page(String elementName) throws InterruptedException {
        autoTrader.verifyElementIsVisible(elementName);

    }

    @When("^I click on \"([^\"]*)\" Auto Trader page$")
    public void i_click_on_auto_trader_page(String elementName) {
        autoTrader.clickOnElement(elementName);
    }

    @When("^I enter \"([^\"]*)\" in \"([^\"]*)\" field on  Auto Trader page$")
    public void i_enter_in_field_on_auto_trader_page(String text, String elementName) {
        autoTrader.clearInputSendKeys(text, elementName);
    }

    @When("^I select \"([^\"]*)\" in \"([^\"]*)\" drop down on  Auto Trader page$")
    public void i_click_dropDown_on_auto_trader_page(String text, String elementName) {
        autoTrader.clickAndSelectFromDropDown(text, elementName);
    }

    @Then("^I verify only BMW cars are visible on the Auto trader page$")
    public void i_verify_only_BMW_cars_are_visible_on_the_autoTrader_page() {
        autoTrader.verifyOnlyBMWCarsAreVisible();
    }
}