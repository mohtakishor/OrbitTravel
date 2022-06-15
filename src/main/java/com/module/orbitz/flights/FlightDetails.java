package com.module.orbitz.flights;

import com.module.orbitz.utils.Constants;
import com.module.orbitz.utils.PageHandle;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FlightDetails {
    private static final Logger logger = LoggerFactory.getLogger(FlightDetails.class);
    WebDriver driver;
    By clickOnLeavingFrom = By.xpath("//button[@aria-label='Leaving from']");
    By clickOnGoingTo = By.xpath("//button[@aria-label='Going to']");
    By enterOnLeavingFrom = By.id("location-field-leg1-origin");
    By enterOnGoingTo = By.id("location-field-leg1-destination");
    By listOfDestination = By.xpath("//*[@class='uitk-typeahead-result-item has-subtext']");
    By goingTo = By.xpath("//button[@aria-label='Goa (GOI - Dabolim) India']");
    By clickOnCalendar = By.xpath("//button[@id='d1-btn']");
    By clickOnDatePicker = By.xpath("//button[@class='uitk-date-picker-day']");
    By clickOnDone = By.xpath("//div[@class='uitk-layout-flex uitk-date-picker-menu-footer']//button[text()='Done']");
    By searchButton = By.xpath(" //button[text()='Search']");

    public FlightDetails(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click and enter From Destination")
    public FlightDetails fromDestinationBox(String fromDestination) {
        WebElement clickOnFromDestination = driver.findElement(clickOnLeavingFrom);
        clickOnFromDestination.click();
        WebElement enterFromDestination = driver.findElement(enterOnLeavingFrom);
        PageHandle.clickAndSend(enterFromDestination, fromDestination);
        List<WebElement> listOfName = driver.findElements(listOfDestination);
        listOfName.get(0).click();
        return new FlightDetails(driver);
    }

    @Step("Click and enter TO Destination")
    public FlightDetails toDestinationBox(String toDestination) {
        WebElement clickOnToDestination = driver.findElement(clickOnGoingTo);
        clickOnToDestination.click();
        WebElement enterToDestination = driver.findElement(enterOnGoingTo);
        PageHandle.clickAndSend(enterToDestination, toDestination);
        WebElement toGoPlace=driver.findElement(goingTo);
        toGoPlace.click();
        return new FlightDetails(driver);
    }

    public FlightDetails selectDates() {
        WebElement calendar = driver.findElement(clickOnCalendar);
        calendar.click();
        List<WebElement> pickDate = driver.findElements(clickOnDatePicker);
        pickDate.get(10).click();
        pickDate.get(10 + 10).click();
        WebElement done = driver.findElement(clickOnDone);
        done.click();
        return new FlightDetails(driver);
    }

    public FlightDetails submitTheTripDetails() {
        WebElement clickSearchBtn = driver.findElement(searchButton);
        clickSearchBtn.click();
        return new FlightDetails(driver);
    }
}