Feature: Valet Parking
  In order to charge the correct amount
  System should be able to calculate the correct parking fee

  @regression
  Scenario Outline: Valet Parking - Boundary Value analysis
    Given the parking cost calculator system
    When the user selects the <ParkingLot> rate
    And the user starts the parking at <StartingDate> and <StartingTime> and sets <StartingAMPM>
    And the user closes the parking at <LeavingDate> and <LeavingTime> and sets <LeavingTimeAMPM>
    Then the system estimates the <parking_cost> ticket price

    Examples:
      | ParkingLot | StartingDate | StartingTime | StartingAMPM | LeavingDate  | LeavingTime | LeavingTimeAMPM | parking_cost |
      | "Valet"    | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "7:59"      | "AM"            | "$ 0.00"     |
      | "Valet"    | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "8:00"      | "AM"            | "$ 12.00"    |
      | "Valet"    | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "8:01"      | "AM"            | "$ 12.00"    |
      | "Valet"    | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "1:00"      | "PM"            | "$ 12.00"    |
      | "Valet"    | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "1:01"      | "PM"            | "$ 18.00"    |
      | "Valet"    | "10/18/2019" | "8:00"       | "AM"         | "10/18/2019" | "6:00"      | "PM"            | "$ 18.00"    |
      | "Valet"    | "10/18/2019" | "8:00"       | "AM"         | "10/19/2019" | "8:00"      | "AM"            | "$ 18.00"    |
      | "Valet"    | "10/18/2019" | "8:00"       | "AM"         | "10/19/2019" | "8:01"      | "AM"            | "$ 36.00"    |
      | "Valet"    | "10/18/2019" | "8:00"       | "AM"         | "10/19/2019" | "1:00"      | "PM"            | "$ 36.00"    |
      | "Valet"    | "10/18/2019" | "8:00"       | "AM"         | "10/19/2019" | "1:01"      | "PM"            | "$ 36.00"    |
      | "Valet"    | "10/18/2019" | "8:00"       | "AM"         | "10/20/2019" | "8:00"      | "AM"            | "$ 36.00"    |
      | "Valet"    | "10/18/2019" | "8:00"       | "AM"         | "10/20/2019" | "8:01"      | "AM"            | "$ 54.00"    |

  @regression @negative
  Scenario Outline: Negative test
    Given the parking cost calculator system
    When the user selects the <ParkingLot> rate
    And the user starts the parking at <StartingDate> and <StartingTime> and sets <StartingAMPM>
    And the user closes the parking at <LeavingDate> and <LeavingTime> and sets <LeavingTimeAMPM>
    Then the system displays a the following <warning> in the price cell

    Examples:
      | ParkingLot | StartingDate | StartingTime | StartingAMPM | LeavingDate  | LeavingTime | LeavingTimeAMPM | warning                                                                 |
      | "Valet"    | "10/18/2019" | "8:00"       | "AM"         | "10/17/2019" | "8:00"      | "AM"            | "ERROR! YOUR LEAVING DATE OR TIME IS BEFORE YOUR STARTING DATE OR TIME" |