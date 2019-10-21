package com.liferay.uiautomation.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager implements Driver {

    @Override
    public WebDriver initialize() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
