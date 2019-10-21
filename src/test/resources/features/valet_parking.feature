Feature: Valet Parking
  In order to charge the correct amount
  System should be able to calculate the correct parking fee

  Scenario Outline: Positive scenarios
    Given the parking cost calculator system
    When the user selects the <ParkingLot> rate
    And the user starts the parking at <StartingDate> and <StartingTime> and sets <StartingAMPM>
    And the user closes the parking at <LeavingDate> and <LeavingTime> and sets <LeavingTimeAMPM>

    Then the system estimates the <parking_cost> ticket price
    Examples:
      | ParkingLot | StartingDate | StartingTime | StartingAMPM | LeavingDate  | LeavingTime | LeavingTimeAMPM | parking_cost |
      # -1 minute
      | "Valet"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "7:59"      | "AM"            | "$ 0.00"     |
     # 0 minute
      | "Valet"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "8:00"      | "AM"            | "$ 12.00"    |
      # 1 minute
      | "Valet"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "8:01"      | "AM"            | "$ 12.00"    |
      # 5 hours
      | "Valet"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "1:00"      | "PM"            | "$ 12.00"    |
      # 5 hours and a minute
      | "Valet"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "1:01"      | "PM"            | "$ 18.00"    |
      # 10 hours
      | "Valet"      | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "6:00"      | "PM"            | "$ 18.00"    |
      # 1 day
      | "Valet"      | "10/18/2019" | "8:00"       | "AM"         | "10/19/2019" | "8:00"      | "AM"            | "$ 18.00"    |
      # 1 day and a minute
      | "Valet"      | "10/18/2019" | "8:00"       | "AM"         | "10/19/2019" | "8:01"      | "AM"            | "$ 36.00"    |
      # 1 day and 5 hours
      | "Valet"      | "10/18/2019" | "8:00"       | "AM"         | "10/19/2019" | "1:00"      | "PM"            | "$ 36.00"    |
      # 1 day and 5 hours and 1 minute
      | "Valet"      | "10/18/2019" | "8:00"       | "AM"         | "10/19/2019" | "1:01"      | "PM"            | "$ 36.00"    |
      # 2 days
      | "Valet"      | "10/18/2019" | "8:00"       | "AM"         | "10/20/2019" | "8:00"      | "AM"            | "$ 36.00"    |
      # 2 days and 1 minute
      | "Valet"      | "10/18/2019" | "8:00"       | "AM"         | "10/20/2019" | "8:01"      | "AM"            | "$ 54.00"    |
