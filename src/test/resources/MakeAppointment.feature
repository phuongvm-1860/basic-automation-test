Feature: Make appointment
  As a user
  I want to make an appointment
  So I can see doctor

  Scenario Outline: User can make appointment with valid information
    Given user signed in with "John Doe" and "ThisIsNotAPassword"
    When user select facility as "<facility>"
    And user "<action>" in checkbox
    And user choose program as "<healthcare program>"
    And user input date as "<date>"
    And user add comment as "<comment>"
    And user clicks on Book Appointment button
    Then user sees facility display as "<facility>"
    And user sees "<action>" in checkbox
    And user sees "<healthcare program>" is display
    And user sees appointment date as "<date>"
    And user sees comment as "<comment>"
    Examples:
      | facility                        | action | healthcare program | date       | comment          |
      | Tokyo CURA Healthcare Center    | Yes    | Medicare           | 18/12/2020 | No comment added |
      | Hongkong CURA Healthcare Center | No     | Medicaid           | 30/12/2020 |                  |
      | Seoul CURA Healthcare Center    | Yes    | None               | 04/01/2021 | No comment added |

  Scenario: User cannot make appointment with invalid information
    Given user signed in with "John Doe" and "ThisIsNotAPassword"
    When user select facility as "Tokyo CURA Healthcare Center"
    And user "Checked" in checkbox
    And user choose program as "Medicare"
    And user add comment as "No comment added"
    And user clicks on Book Appointment button
    Then user sees alert
