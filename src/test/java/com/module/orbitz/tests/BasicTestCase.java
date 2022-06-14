package com.module.orbitz.tests;

import com.module.orbitz.browsers.ChromeBrowser;
import com.module.orbitz.utils.Constants;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class BasicTestCase {
    WebDriver driver;

    @BeforeMethod
    @Description("Open Chrome as an browser and to go Orbitz URL")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserStack\\chromedriver.exe");
        driver = new ChromeBrowser().getDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Constants.URL);
    }

    @AfterMethod
    public void close() {
        driver.close();
    }

    @Test
    public void base() {
        System.out.println("Base test to get open browser");
    }
}