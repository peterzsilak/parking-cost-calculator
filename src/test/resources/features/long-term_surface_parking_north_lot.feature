Feature: Long-Term Surface Parking North Lot
  In order to charge the correct amount
  System should be able to calculate the correct parking fee

  @regression
  Scenario Outline: Long-Term Surface Parking North Lot
    Given the parking cost calculator system
    When the user selects the <ParkingLot> rate
    And the user starts the parking at <StartingDate> and <StartingTime> and sets <StartingAMPM>
    And the user closes the parking at <LeavingDate> and <LeavingTime> and sets <LeavingTimeAMPM>
    Then the system estimates the <parking_cost> ticket price
    Examples:
      | ParkingLot     | StartingDate | StartingTime | StartingAMPM | LeavingDate  | LeavingTime | LeavingTimeAMPM | parking_cost |
      | "Long-Surface" | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "7:59"      | "AM"            | "$ 0.00"     |
      | "Long-Surface" | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "8:00"      | "AM"            | "$ 0.00"     |
      | "Long-Surface" | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "8:01"      | "AM"            | "$ 2.00"     |
      | "Long-Surface" | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "8:59"      | "AM"            | "$ 2.00"     |
      | "Long-Surface" | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "9:01"      | "AM"            | "$ 4.00"     |
      | "Long-Surface" | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "12:59"     | "AM"            | "$ 10.00"    |
      | "Long-Surface" | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "13:00"     | "AM"            | "$ 10.00"    |
      | "Long-Surface" | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "13:01"     | "AM"            | "$ 10.00"    |
      | "Long-Surface" | "10/18/2019" | "8:00"       | "AM"         | "10/25/2019" | "7:59"      | "AM"            | "$ 60.00"    |
      | "Long-Surface" | "10/18/2019" | "8:00"       | "AM"         | "10/25/2019" | "8:00"      | "AM"            | "$ 60.00"    |
      | "Long-Surface" | "10/18/2019" | "8:00"       | "AM"         | "10/25/2019" | "8:01"      | "AM"            | "$ 62.00"    |