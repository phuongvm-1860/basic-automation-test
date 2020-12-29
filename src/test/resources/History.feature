Feature: History
  As a user
  I want to see appointment history
  So I can remember my appointments

  Background:
    Given user signed in with username as "John Doe" and password as "ThisIsNotAPassword"
    And user is in appointment page

  Scenario: User can book appointment then see history
    When user books appointment as below
      | facility_input                  | readmission_input | program_input | date_input | comment_input  |
      | Tokyo CURA Healthcare Center    | Yes               | Medicare      | 30/12/2020 | Test comment 1 |
      | Hongkong CURA Healthcare Center | Yes               | Medicaid      | 31/12/2020 | Test comment 2 |
      | Seoul CURA Healthcare Center    | No                | None          | 01/01/2021 |                |
    And user clicks menu icon
    And user clicks history
    Then user sees list of appointments as below
      | facility_history                | readmission_history | program_history | date_history | comment_history |
      | Tokyo CURA Healthcare Center    | Yes                 | Medicare        | 30/12/2020   | Test comment 1  |
      | Hongkong CURA Healthcare Center | Yes                 | Medicaid        | 31/12/2020   | Test comment 2  |
      | Seoul CURA Healthcare Center    | No                  | None            | 01/01/2021   |                 |