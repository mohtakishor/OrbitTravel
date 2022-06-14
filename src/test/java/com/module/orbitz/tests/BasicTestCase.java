package com.module.orbitz.tests;

import com.module.orbitz.browsers.ChromeBrowser;
import com.module.orbitz.flights.FlightDetails;
import com.module.orbitz.homePage.HomePage;
import com.module.orbitz.utils.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class BasicTestCase {
    WebDriver driver;

    @BeforeTest
    @Description("Open Chrome as an browser and to go Orbitz URL")
    public void setup() {
        driver = new ChromeBrowser().getDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Constants.URL);
    }

    @AfterMethod
    public void close() {
        driver.close();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify home page products")
    @Test
    public void homePageVerification() {
        new HomePage(driver).selectStayTab().selectFlightTab();
        new FlightDetails(driver).fromDestinationBox("Blr").toDestinationBox("Goa");
    }
}