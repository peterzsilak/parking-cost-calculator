package com.liferay.uiautomation.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager implements Driver {

    private static ChromeDriverManager chromeDriverManager = new ChromeDriverManager();

    public ChromeDriverManager() {
    }

    public static ChromeDriverManager getChromeDriverManager() {
        return chromeDriverManager;
    }

    @Override
    public WebDriver initialize() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
