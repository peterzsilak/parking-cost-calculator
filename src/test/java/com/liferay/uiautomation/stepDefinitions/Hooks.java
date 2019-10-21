package com.liferay.uiautomation.stepDefinitions;

import com.liferay.uiautomation.driver.GenericDriver;
import org.junit.After;
import org.junit.Before;

public class Hooks {

    @Before
    public void setup() {
        GenericDriver.initializeDriverInstance();
    }

    @After
    public void teardown(){
        GenericDriver.destroyDriverInstance();
    }
}
