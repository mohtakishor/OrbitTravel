package com.module.orbitz.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageHandle {
    public static void selectFromDropDown(WebElement element, String value) {
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(value);
    }

    public static void clickAndSend(WebElement element, String value) {
        element.click();
        element.sendKeys(value);
    }

    public static String selectRandomOption(WebElement options) {
        Select dropDown = new Select(options);
        List<WebElement> optionList = dropDown.getOptions();
        int index = RandomData.getRandomNumberBetween(1, optionList.size() - 1);
        String selectedText = optionList.get(index).getText();

        dropDown.selectByIndex(index);
        return selectedText;
    }

    public static WebElement explicitWait(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30));
        WebElement elementFound = wait.until(ExpectedConditions.visibilityOf(element));
        return elementFound;
    }
}