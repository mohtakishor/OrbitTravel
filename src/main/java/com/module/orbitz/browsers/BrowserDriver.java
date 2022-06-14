package com.module.orbitz.browsers;

import org.openqa.selenium.WebDriver;

public interface BrowserDriver {

    WebDriver getDriver();

    void setPathForDriver();
}

