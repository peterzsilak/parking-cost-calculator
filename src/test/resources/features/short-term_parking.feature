Feature: Short-Term (hourly) Parking
  In order to charge the correct amount
  System should be able to calculate the correct parking fee

  Scenario Outline: Short-Term (hourly) Parking
    Given the parking cost calculator system
    When the user selects the <ParkingLot> rate
    And the user starts the parking at <StartingDate> and <StartingTime> and sets <StartingAMPM>
    And the user closes the parking at <LeavingDate> and <LeavingTime> and sets <LeavingTimeAMPM>
    Then the system estimates the <parking_cost> ticket price
    Examples:
      | ParkingLot | StartingDate | StartingTime | StartingAMPM | LeavingDate  | LeavingTime | LeavingTimeAMPM | parking_cost |
      | "Short"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "7:59"      | "AM"            | "$ 0.00"     |
      | "Short"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "8:00"      | "AM"            | "$ 2.00"     |
      | "Short"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "9:00"      | "AM"            | "$ 2.00"     |
      | "Short"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "9:01"      | "AM"            | "$ 3.00"     |
      | "Short"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "9:31"      | "AM"            | "$ 4.00"     |
      | "Short"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "19:30"     | "AM"            | "$ 23.00"    |
      | "Short"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "7:30"      | "PM"            | "$ 23.00"    |
      | "Short"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "19:30"     | "AM"            | "$ 23.00"    |
      | "Short"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "19:31"     | "AM"            | "$ 24.00"    |
      | "Short"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "20:00"     | "AM"            | "$ 24.00"    |
      | "Short"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "20:01"     | "AM"            | "$ 24.00"    |