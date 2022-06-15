package com.module.orbitz.searchPage;

import com.module.orbitz.utils.Constants;
import com.module.orbitz.utils.PageHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class AssertionsAfterSearchQuery {
    private static final Logger logger = LoggerFactory.getLogger(AssertionsAfterSearchQuery.class);
    WebDriver driver;
    By signIn = By.cssSelector("div#gc-custom-header-nav-bar-acct-menu");
    By createAccountText = By.xpath("//*[text()='Create a free account']");
    By flexibleDate = By.xpath("//div[@class='uitk-expando-button-content']");
    By calendarOfFlexibleDate = By.xpath("//div[@class='uitk-date-range-grid']");
    By goingTo = By.xpath("//button[text()='Goa (GOI-Dabolim)']");

    public AssertionsAfterSearchQuery(WebDriver driver) {
        this.driver = driver;
    }

    public AssertionsAfterSearchQuery verifySignInbutton() {
        WebElement getSignIn = driver.findElement(signIn);
        getSignIn.click();
        WebElement getCreateAccount = driver.findElement(createAccountText);
        PageHandle.explicitWait(driver, getCreateAccount);
        Assert.assertEquals(getCreateAccount.getText(), Constants.CREATEACCOUNTEXPECTEDRESULT);
        return new AssertionsAfterSearchQuery(driver);
    }

    public AssertionsAfterSearchQuery verifyFlexibleDatesTabToOpenCalendar() {
        WebElement flexibleDateCalendar = driver.findElement(flexibleDate);
        flexibleDateCalendar.click();
        WebElement flexibleCalendar = driver.findElement(calendarOfFlexibleDate);
        Assert.assertTrue(flexibleCalendar.isDisplayed());
        flexibleDateCalendar.click();
        return new AssertionsAfterSearchQuery(driver);
    }

    public AssertionsAfterSearchQuery verifyDestinationsFromAndTo() {
        WebElement goingToDestination = driver.findElement(goingTo);
        PageHandle.explicitWait(driver, goingToDestination);
        Assert.assertEquals(goingToDestination.getText(), Constants.CityConstantsFlights.GOI);
        return new AssertionsAfterSearchQuery(driver);
    }
}