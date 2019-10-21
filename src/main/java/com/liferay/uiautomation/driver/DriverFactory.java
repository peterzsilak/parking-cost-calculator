package com.liferay.uiautomation.driver;

public class DriverFactory {

    public Driver chooseBrowser(){

        String browserName = "chrome";

        if(browserName.equalsIgnoreCase("firefox")){
            return new FirefoxDriverManager();
        }
        else if(browserName.equalsIgnoreCase("chrome")){
            return new ChromeDriverManager();
        }
        return null;
    }

}
