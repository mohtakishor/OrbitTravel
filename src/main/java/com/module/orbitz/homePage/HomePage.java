package com.module.orbitz.homePage;

import com.module.orbitz.utils.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class HomePage {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    static String productsName = "";
    WebDriver driver;
    By clickOnFlight = By.xpath("//span[text()='Flights']");
    By clickOnStays = By.xpath("//span[text()='Stays']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on flight tab from Home Page")
    public HomePage selectFlightTab() {
        WebElement clickOnFlightTab = driver.findElement(clickOnFlight);
        productsName = clickOnFlightTab.getText();
        logger.info("Click on " + productsName);
        Assert.assertEquals(productsName, Constants.FLIGHTTAB);
        clickOnFlightTab.click();
        return new HomePage(driver);
    }

    @Step("Click on Stay tab from Home Page")
    public HomePage selectStayTab() {
        WebElement clickOnStaysTab = driver.findElement(clickOnStays);
        productsName = clickOnStaysTab.getText();
        logger.info("Click on " + productsName);
        Assert.assertEquals(productsName, Constants.STAYSTAB);
        clickOnStaysTab.click();
        return new HomePage(driver);
    }
}
