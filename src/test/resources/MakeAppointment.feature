Feature: Make Appointment

  As an user
  I want to make appointment
  So I can use the app

  Scenario Outline: User booking appointment successfully
    Given user login with username "John Doe" and password "ThisIsNotAPassword"
    When user sets facility as "<facility>"
    And user "<check>" on check box
    And user sets healthcare program as "<healthcare_program>"
    And user set visit date as "<visit_date>"
    And user sets comment as "<comment>"
    And user clicks on Booking Appointment button
    Then user sees Appointment Confirmation page with data
      | facility                        | check | healthcare_program | visit_date  | comment |
    Examples:
      | facility                        | check | healthcare_program | visit_date | comment |
      | Tokyo CURA Healthcare Center    | Yes   | Medicare           | 05/01/2021 |         |
      | Tokyo CURA Healthcare Center | No    | Medicaid           | 17/12/2020 | hihi    |
      | Tokyo CURA Healthcare Center    | Yes   | None               | 30/12/2020 | keke    |
















