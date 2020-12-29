Feature: Appointment
  As a user
  I want to make appointment
  So I can meet doctor easily

  Background:
    Given user signed in with username as "John Doe" and password as "ThisIsNotAPassword"
    And user is in appointment page

  Scenario Outline: User can book appointment with different facilities and healthcare programs
    When user selects facility as "<facility>"
    And user select readmission as "<readmission>"
    And user selects program as "<program>"
    And user selects date as "<date>"
    And user inputs comment as "<comment>"
    And user clicks book appointment button
    Then user sees facility as "<facility>"
    And user sees readmission as "<readmission>"
    And user sees program as "<program>"
    And user sees date as "<date>"
    And user sees comment as "<comment>"
    Examples:
      | facility                        | readmission | program  | date       | comment        |
      | Tokyo CURA Healthcare Center    | Yes     | Medicare | 30/12/2020 | Test comment 1 |
      | Hongkong CURA Healthcare Center | Yes     | Medicaid | 31/12/2020 | Test comment 2 |
      | Seoul CURA Healthcare Center    | No   | None     | 01/01/2021 |                |
