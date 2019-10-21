package com.liferay.uiautomation.stepDefinitions;

import com.liferay.uiautomation.driver.GenericDriver;
import com.liferay.uiautomation.pageObject.ParkingCostCalculatorPage;
import org.openqa.selenium.WebDriver;

public class PageLoader {

    public WebDriver driver = GenericDriver.initializeDriverInstance().getDriver();

    public ParkingCostCalculatorPage parkingCostCalculator = new ParkingCostCalculatorPage(driver);
}
