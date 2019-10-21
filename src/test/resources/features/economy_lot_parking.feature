Feature: Economy Lot Parking
  In order to charge the correct amount
  System should be able to calculate the correct parking fee

  @regression
  Scenario Outline: Economy Lot Parking
    Given the parking cost calculator system
    When the user selects the <ParkingLot> rate
    And the user starts the parking at <StartingDate> and <StartingTime> and sets <StartingAMPM>
    And the user closes the parking at <LeavingDate> and <LeavingTime> and sets <LeavingTimeAMPM>
    Then the system estimates the <parking_cost> ticket price
    Examples:
      | ParkingLot | StartingDate | StartingTime | StartingAMPM | LeavingDate  | LeavingTime | LeavingTimeAMPM | parking_cost |
      | "Economy"    | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "7:59"      | "AM"            | "$ 0.00"     |