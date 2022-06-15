package com.module.orbitz.tests;

import com.module.orbitz.browsers.ChromeBrowser;
import com.module.orbitz.flights.FlightDetails;
import com.module.orbitz.homePage.HomePage;
import com.module.orbitz.searchPage.AssertionsAfterSearchQuery;
import com.module.orbitz.utils.Constants;
import com.module.orbitz.utils.EmailReporting;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
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

    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify home page products")
    @Test(priority = 1)
    public void homePageVerification() {
        new HomePage(driver).selectStayTab().selectFlightTab();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify flight")
    @Test(priority = 2)
    public void selectFlightProduct() {
        new FlightDetails(driver).fromDestinationBox("Sin").toDestinationBox("Goa").selectDates().submitTheTripDetails();
        new AssertionsAfterSearchQuery(driver).verifySignInbutton().verifyFlexibleDatesTabToOpenCalendar().verifyDestinationsFromAndTo();
    }

    @AfterTest
    public void close() {
        EmailReporting.sendmail();
        driver.close();
    }
}