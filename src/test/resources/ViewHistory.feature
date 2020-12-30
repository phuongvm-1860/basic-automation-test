Feature: View History
  As a user
  I want to view history
  So I can view appointment history list

  Scenario Outline: User can view history after book appointment
    Given user signed in with "John Doe" and "ThisIsNotAPassword"
    When user select facility as "<facility>"
    And user "<action>" in checkbox
    And user choose program as "<healthcare program>"
    And user input date as "<date>"
    And user add comment as "<comment>"
    And user clicks on Book Appointment button
    And user clicks on sidebar
    And user clicks on History
    Then user sees List of Appointments as below
      | facility   | apply read_mission | healthcare_program   | date   | comment   |
      | <facility> | <action>           | <healthcare program> | <date> | <comment> |
    Examples:
      | facility                        | action | healthcare program | date       | comment               |
      | Tokyo CURA Healthcare Center    | Yes    | Medicare           | 18/12/2020 | No comment added here |
      | Hongkong CURA Healthcare Center | No     | Medicaid           | 30/12/2020 |                       |
      | Seoul CURA Healthcare Center    | Yes    | None               | 04/01/2021 | No comment added here |

  Scenario: User can view history after book 2 appointment
    Given user signed in with "John Doe" and "ThisIsNotAPassword"
    When user input data as below
      | facilityList                 | actionList | programList | inputDate  | inputComment          |
      | Tokyo CURA Healthcare Center | Yes        | Medicare    | 18/12/2020 | No comment added here |
      | Seoul CURA Healthcare Center | No         | None        | 04/01/2021 |                       |
    And user clicks on sidebar
    And user clicks on History
    Then user sees List of Appointments as below
      | facility                     | apply read_mission | healthcare_program | date       | comment               |
      | Tokyo CURA Healthcare Center | Yes                | Medicare           | 18/12/2020 | No comment added here |
      | Seoul CURA Healthcare Center | No                 | None               | 04/01/2021 |                       |
