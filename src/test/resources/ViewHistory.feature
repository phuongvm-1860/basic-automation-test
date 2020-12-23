Feature: View History
  An a user
  I want to check history add appointment
  So I can use function view history to check

  Scenario: User can book appointment with valid value2
    Given the user login with username as "John Doe" and password as "ThisIsNotAPassword"
    When user inputs all items value as below
      | facility                        | apply_for_hospital | health_care | visit_date | comment            |
      | Hongkong CURA Healthcare Center | yes                 | Medicare    | 02/12/2020 | Khong co comment 1 |
      | Seoul CURA Healthcare Center    | no                  | Medicaid    | 05/12/2020 | Khong co comment 2 |
    And user clicks at menu
    And user selects history
    Then user sees appointment as below
      | facility1                       | apply_for_hospital1 | health_care1 | visit_date1 | comment1           |
      | Hongkong CURA Healthcare Center | Yes                  | Medicare     | 02/12/2020  | Khong co comment 1 |
      | Seoul CURA Healthcare Center    | No                   | Medicaid     | 05/12/2020  | Khong co comment 2 |
