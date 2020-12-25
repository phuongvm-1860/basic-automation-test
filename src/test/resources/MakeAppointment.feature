Feature: Make Appointment

  An a user
  I want to sign in
  So I can use the app
  After that I fill fields to make my appointment

  @automated
  Scenario Outline: User can make appointment with valid value
    Given user is in Katalon login page
    When user sets username as "John Doe" and password as "ThisIsNotAPassword"
    And user clicks on login button
    Then user sees appointment page
    When user select facility as "<facilityBox>"
    And user "<action>" apply
    And user chooses "<program>"
    And user decides "<date>"
    And user adds "<comment>"
    And user clicks on Book appointment button
    Then user created appointment successfully
    And user sees "<facilityBox>" as input
    And user observes "<action>" as input
    And user can see "<program>" as input
    And user can observe "<date>" as input
    And user notices "<comment>" as input
    Then user clicks homepage button
    Examples:
      | facilityBox                     | action | program  | date       | comment |
      | Tokyo CURA Healthcare Center    | tick   | Medicare | 01/12/2020 | abc        |
      | Hongkong CURA Healthcare Center |   | Medicaid | 24/12/2020 | xyz        |

