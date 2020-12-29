Feature: View History
  As a user I want to see List of Appointments I have created
  So I can use the app

  Scenario: User can see Appointment Confirmation when User create 2 Appointment
    Given an user login with account "John Doe" and password as "ThisIsNotAPassword"
    When User input data as below
      | Facility                        | Apply for hospital readmission | Healthcare Program | Visit Date | Comment |
      | Tokyo CURA Healthcare Center    | Yes                            | Medicare           | 01/12/2020 | 123     |
      | Hongkong CURA Healthcare Center | No                             | Medicaid           | 01/01/2021 |         |
    And User click to Menu button
    And User click to History
    Then User can see facility as below

      | Facility1                       | Apply for hospital readmission1 | Healthcare Program1 | Visit Date1 | Comment1 |
      | Tokyo CURA Healthcare Center    | Yes                             | Medicare            | 01/12/2020  | 123      |
      | Hongkong CURA Healthcare Center | No                              | Medicaid            | 01/01/2021  |          |