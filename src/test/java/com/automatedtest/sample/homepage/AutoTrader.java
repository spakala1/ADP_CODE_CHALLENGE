package com.automatedtest.sample.homepage;

import com.automatedtest.sample.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AutoTrader extends BasePage {

    AutoTrader() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[text()='Browse by Make']")
    private static WebElement browseByMake;

    @FindBy(xpath = "//*[text()='Browse by Style']")
    private static WebElement browseByStyle;

    @FindBy(xpath = "//*[text()='Advanced Search']")
    private static WebElement advancedSearch;

    @FindBy(xpath = "//*[text()='Search']")
    private static WebElement searchButton;

    @FindBy(xpath = "//*[contains(text(),'Advanced Search')]/ following:: select[1]")
    private static WebElement makeDropDown;

    @FindBy(xpath = "//*[contains(text(),'Advanced Search')]/ following:: select[2]")
    private static WebElement modelDropDown;

    @FindBy(xpath = "//h2[contains(text(),'Location')]")
    private static WebElement locationText;

    @FindBy(xpath = "//h2[contains(text(),'Location')]/following::input[1]")
    private static WebElement zipCodeInput;

    @FindBy(xpath = "//*[text()='Certified']")
    private static WebElement certifiedCheckBox;

    @FindBy(xpath = "//div[text()='Convertible']")
    private static WebElement convertibleCheckBox;

    @FindBy(xpath = "///label[text()='From']/following::select[1]")
    private static WebElement fromYear;

    @FindBy(xpath = "//label[text()='From']/following::select[2]")
    private static WebElement toYear;

    @FindBy(xpath = "//*[text()='Vehicle 1']/following::select[1]")
    private static WebElement vehicle1DropDown;

    List<WebElement> listOfBMWCars = driver.findElements(By.xpath("//h2[contains(text(),'Certified 2')]"));

    private static final String BROWSE_BY_MAKE = "Browse by Make";
    private static final String BROWSE_BY_STYLE = "Browse by Style";
    private static final String ADVANCED_SEARCH = "Advanced Search";
    private static final String SEARCH_BUTTON = "Search Button";
    private static final String MAKE_DROP_DOWN = "Make Drop Down";
    private static final String MODEL_DROP_DOWN = "Model Drop Down";
    private static final String LOCATION_TEXT = "Location";
    private static final String ZIPCODE_INPUT = "Zip Code";
    private static final String CERTIFIED_CHECK_BOX = "Certified Check Box";
    private static final String CONVERTIBLE_CHECK_BOX = "Convertible Check Box";
    private static final String From = "From";
    private static final String TO = "To";
    private static final String VEHICLE_1_DROPDOWN = "Vehicle 1";
    private static final String HOME_PAGE_URL = "https://www.autotrader.com/";

    /**
     * return the webelement.
     *
     * @param elementName - Name of the Web Element
     * @return - WebElement
     */
    public WebElement returnElement(String elementName) {
        switch (elementName) {
            case BROWSE_BY_MAKE:
                return browseByMake;
            case BROWSE_BY_STYLE:
                return browseByStyle;
            case ADVANCED_SEARCH:
                return advancedSearch;
            case SEARCH_BUTTON:
                return searchButton;
            case MAKE_DROP_DOWN:
                return makeDropDown;
            case MODEL_DROP_DOWN:
                return modelDropDown;
            case LOCATION_TEXT:
                return locationText;
            case CERTIFIED_CHECK_BOX:
                return certifiedCheckBox;
            case CONVERTIBLE_CHECK_BOX:
                return convertibleCheckBox;
            case ZIPCODE_INPUT:
                return zipCodeInput;
            case From:
                return fromYear;
            case TO:
                return toYear;
            case VEHICLE_1_DROPDOWN:
                return vehicle1DropDown;
            default:
                Assert.fail("FAIL: Could not find icon that matched string passed from step");
                return null;
        }
    }

    /**
     * Launches the web page
     */
    public void goToHomePage() {

        driver.get(HOME_PAGE_URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        wait.forLoading(10);
    }

    /**
     * verify if the element is visible on the page
     *
     * @param elementName - Name of the Web Element
     */
    public void verifyElementIsVisible(String elementName) {
        wait.forElementToBeDisplayed(5, returnElement(elementName), elementName);
        Assert.assertTrue("FAIL: Yellow Triangle not present", returnElement(elementName).isDisplayed());
    }

    /**
     * Click on an element
     *
     * @param elementName - Name of the Web Element
     */
    public void clickOnElement(String elementName) {
        wait.forElementToBeDisplayed(15, returnElement(elementName), elementName);
        returnElement(elementName).click();
    }

    /**
     * enters text in any input box on the page
     *
     * @param elementName - Name of the Web Element
     * @param text-       Text to be entered
     */
    public void clearInputSendKeys(String text, String elementName) {
        wait.forElementToBeDisplayed(15, returnElement(elementName), elementName);
        returnElement(elementName).click();
        returnElement(elementName).clear();
        returnElement(elementName).sendKeys(text);
    }

    /**
     * Selects the value in the dropdown.
     *
     * @param elementName - Name of the Web Element
     * @param text        - value to be selected in the dropdown
     */
    public void clickAndSelectFromDropDown(String text, String elementName) {

        wait.forElementToBeDisplayed(15, returnElement(elementName), elementName);
        Select dropDown = new Select(returnElement(elementName));
        dropDown.selectByValue(text);

    }

    /**
     * Verifies only BMW cars are visible on the page
     */
    public void verifyOnlyBMWCarsAreVisible() {

        wait.forLoading(15);
        for (int i = 0; i <= listOfBMWCars.size(); i++) {
            String text = listOfBMWCars.get(i).getText();
            Assert.assertTrue("Text not found!", text.contains("BMW"));
        }
        System.out.println("THE TOTAL NUMBER OF BMW CARS VISIBLE ON THE PAGE ARE" + listOfBMWCars.size());

    }
}
