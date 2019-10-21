package com.liferay.uiautomation.driver;

import com.liferay.uiautomation.helper.PropertyReader;

import static com.liferay.uiautomation.driver.DriverType.*;

public class DriverFactory {

    public Driver chooseBrowser(){

        String driverType = new PropertyReader().readProperty("DriverType");

        if(driverType.equals(FIREFOX.name())){
            return new FirefoxDriverManager();
        }
        else if(driverType.equals(CHROME.name())){
            return new ChromeDriverManager();
        }
        return null;
    }

}
