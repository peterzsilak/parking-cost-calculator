package com.liferay.uiautomation.stepDefinitions;

import com.liferay.uiautomation.driver.GenericDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        GenericDriver.initializeDriverInstance();
    }

    //TODO: Solution needed for webdriver kill
    //@After
    public void teardown(){
        GenericDriver.destroyDriverInstance();
    }
}
