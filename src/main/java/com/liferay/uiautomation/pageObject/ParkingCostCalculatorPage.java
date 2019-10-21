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

    @FindBy(xpath = "/html/body/form/table/tbody/tr[4]/td[2]/span[1]/b")
    private WebElement calculatedCost;

    @FindBy(xpath = "/html/body/form/table/tbody/tr[4]/td[2]/b")
    private WebElement warning;

    public ParkingCostCalculatorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public ParkingCostCalculatorPage using(WebDriver webDriver){
        return new ParkingCostCalculatorPage(webDriver);
    }

    public ParkingCostCalculatorPage selectParkingLot(String parkingLot) {
        Select parkingLotDropDown = new Select(parkingLotSelect);
        parkingLotDropDown.selectByValue(parkingLot);
        return this;
    }

    public ParkingCostCalculatorPage setStartingDate(String startingDate) {
        startingDateField.clear();
        startingDateField.sendKeys(startingDate);
        return this;
    }

    public ParkingCostCalculatorPage setStartingTime(String startingTime) {
        startingTimeField.clear();
        startingTimeField.sendKeys(startingTime);
        return this;
    }

    public ParkingCostCalculatorPage setStartingAMPM(String startingAMPM) {
        setAMPMRadioBox(startingTimeAMPMRadioBox, startingAMPM);
        return this;
    }

    public ParkingCostCalculatorPage setLeavingDate(String leavingDate) {
        leavingDateField.clear();
        leavingDateField.sendKeys(leavingDate);
        return this;
    }

    public ParkingCostCalculatorPage setLeavingTime(String leavingTime) {
        leavingTimeField.clear();
        leavingTimeField.sendKeys(leavingTime);
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

    public String getWarning(){
        return warning.getText();
    }

    private void setAMPMRadioBox(List<WebElement> AMPMRadioBox, String leavingAMPM) {
        AMPMRadioBox.forEach(radioboxItem -> {
            if (radioboxItem.getAttribute("value").equals(leavingAMPM) && !radioboxItem.isSelected()) {
                radioboxItem.click();
            }
        });
    }

}
