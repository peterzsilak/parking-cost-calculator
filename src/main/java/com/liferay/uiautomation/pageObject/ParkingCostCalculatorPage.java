package com.liferay.uiautomation.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ParkingCostCalculatorPage extends BasePage {

    @FindBy(name = "ParkingLot")
    private WebElement parkingLotSelect;

    @FindBy(name = "StartingDate")
    private WebElement startingDateField;

    @FindBy(name = "StartingTime")
    private WebElement startingTimeField;

    @FindBy(name = "StartingTimeAMPM")
    private List<WebElement> startingTimeAMPMRadioBox;

    @FindBy(name = "LeavingDate")
    private WebElement leavingDateField;

    @FindBy(name = "LeavingTime")
    private WebElement leavingTimeField;

    @FindBy(name = "LeavingTimeAMPM")
    private List<WebElement> leavingTimeAMPMRadioBox;

    @FindBy(name = "Submit")
    private WebElement submitButton;

    @FindBy(className = "td.SubHead>b")
    private WebElement calculatedCost;

    public ParkingCostCalculatorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public ParkingCostCalculatorPage using(WebDriver webDriver){
        return new ParkingCostCalculatorPage(webDriver);
    }

    public ParkingCostCalculatorPage selectParkingLot(ParkingLot parkingLot) {
        Select parkingLotDropDown = new Select(parkingLotSelect);
        parkingLotDropDown.selectByValue(parkingLot.getValue());
        return this;
    }

    public ParkingCostCalculatorPage setStartingDate(String startingDate) {
        startingDateField.sendKeys(startingDate);
        return this;
    }

    public ParkingCostCalculatorPage setStartingTime(String startingTime) {
        startingTimeField.sendKeys(startingTime);
        return this;
    }

    public ParkingCostCalculatorPage setStartingAMPM(String startingAMPM) {
        setAMPMRadioBox(startingTimeAMPMRadioBox, startingAMPM);
        return this;
    }

    public ParkingCostCalculatorPage setLeavingDate(String leavingDate) {
        leavingDateField.sendKeys(leavingDate);
        return this;
    }

    public ParkingCostCalculatorPage setLeavingTime(String leavingTime) {
        startingTimeField.sendKeys(leavingTime);
        return this;
    }

    public ParkingCostCalculatorPage setLeavingAMPM(String leavingAMPM) {
        setAMPMRadioBox(leavingTimeAMPMRadioBox, leavingAMPM);
        return this;
    }

    public ParkingCostCalculatorPage submit(){
        submitButton.click();
        return this;
    }

    public String getCalculatedCost(){
        return calculatedCost.getText();
    }

    private void setAMPMRadioBox(List<WebElement> AMPMRadioBox, String leavingAMPM) {
        AMPMRadioBox.forEach(radioboxItem -> {
            if (radioboxItem.getAttribute("value").equals(leavingAMPM) && !radioboxItem.isSelected()) {
                radioboxItem.click();
            }
        });
    }

}
