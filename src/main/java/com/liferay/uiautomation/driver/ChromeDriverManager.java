package com.liferay.uiautomation.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager implements Driver {

    @Override
    public WebDriver initialize() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
