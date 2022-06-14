package com.module.orbitz.flights;

import com.module.orbitz.utils.PageHandle;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightDetails {
    private static final Logger logger = LoggerFactory.getLogger(FlightDetails.class);
    static String productsName = "";
    WebDriver driver;
    By clickOnLeavingFrom = By.xpath("//button[@aria-label='Leaving from']");
    By clickOnGoingTo = By.xpath("//button[@aria-label='Going to']");

    By enterOnLeavingFrom = By.id("location-field-leg1-origin");
    By enterOnGoingTo = By.id("location-field-leg1-destination");

    //By listOfDestination=By.className("uitk-typeahead-result-item has-subtext");

    By cityname = By.xpath("//*[@aria-label='Bengaluru (BLR - Kempegowda Intl.) India']");

    public FlightDetails(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click and enter From Destination")
    public FlightDetails fromDestinationBox(String fromDestination) {
        WebElement clickOnFromDestination = driver.findElement(clickOnLeavingFrom);
        clickOnFromDestination.click();
        WebElement enterFromDestination = driver.findElement(enterOnLeavingFrom);
        PageHandle.clickAndSend(enterFromDestination, fromDestination);
        WebElement cityNameFrom = driver.findElement(cityname);
        PageHandle.explicitWait(driver, cityNameFrom);
        return new FlightDetails(driver);
    }

    @Step("Click and enter TO Destination")
    public FlightDetails toDestinationBox(String toDestination) {
        WebElement clickOnToDestination = driver.findElement(clickOnGoingTo);
        clickOnToDestination.click();
        WebElement enterToDestination = driver.findElement(enterOnGoingTo);
        PageHandle.clickAndSend(enterToDestination, toDestination);
        return new FlightDetails(driver);
    }
}