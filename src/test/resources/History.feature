Feature: History

  @automated
  Scenario: No history
    Given user is in Katalon login page
    When user sets username as "John Doe" and password as "ThisIsNotAPassword"
    And user clicks on login button
    Then user sees appointment page
    And user clicks hamburger menu
    And user choose history
    And user goes to history page
    Then user sees no Appointment


  @automated
  Scenario: Check history of appointment
    Given user is in Katalon login page
    When user sets username as "John Doe" and password as "ThisIsNotAPassword"
    And user clicks on login button
    Then user sees appointment page
    When user select table as below:
      | facilityBox                     | action | program  | date       | comment |
      | Tokyo CURA Healthcare Center    | tick   | Medicare | 01/12/2020 | abc     |
      | Hongkong CURA Healthcare Center |        | Medicaid | 24/12/2020 | xyz     |
    And user clicks hamburger menu
    And user choose history
    And user goes to history page
    Then user sees history as below:
      | appointment date  | facility                        | action | healthcare program | comment |
      | 01/12/2020        | Tokyo CURA Healthcare Center    | Yes    | Medicare           | abc     |
      | 24/12/2020        | Hongkong CURA Healthcare Center | No     | Medicaid           | xyz     |
