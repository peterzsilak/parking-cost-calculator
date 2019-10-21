package com.liferay.uiautomation.driver;

import org.openqa.selenium.WebDriver;

public class GenericDriver {

    private static GenericDriver obj = new GenericDriver();
    private static WebDriver driver = new DriverFactory().chooseBrowser().initialize();

    public GenericDriver(){}

    public static GenericDriver initializeDriverInstance(){
        return obj;
    }

    public static WebDriver getDriver(){ return driver; }

    public static void destroyDriverInstance() {
        driver.quit();
        driver = null;
    }
}