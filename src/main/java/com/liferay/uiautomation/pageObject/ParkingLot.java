package com.liferay.uiautomation.pageObject;

public enum  ParkingLot {

    Valet ("Valet"),
    Short ("Short"),
    Economy ("Economy"),
    LongGarage ("Long-Garage"),
    LongSurface ("Long-Surface");

    private String value;

    ParkingLot(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
