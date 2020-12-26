Feature: Check History Appointment Confirmation

  As an user
  I want to check history appointment confirmation

  Scenario: User can be view history
    Given user login with username "John Doe" and password "ThisIsNotAPassword"
    And user input data into all field into
      | facility                        | check | healthcare_program | visit_date | comment |
      | Tokyo CURA Healthcare Center    | Yes   | Medicare           | 05/01/2021 |         |
      | Hongkong CURA Healthcare Center | No    | Medicaid           | 17/12/2020 | hihi    |
      | Seoul CURA Healthcare Center    | Yes   | None               | 30/12/2020 | keke    |
    And user clicks on Booking Appointment button
    Then user click on icon menu
    And user click on History button
    Then user sees history appointment
      | facility                        | check | healthcare_program | visit_date | comment |
      | Tokyo CURA Healthcare Center    | Yes   | Medicare           | 05/01/2021 |         |
      | Hongkong CURA Healthcare Center | No    | Medicaid           | 17/12/2020 | hihi    |
      | Seoul CURA Healthcare Center    | Yes   | None               | 30/12/2020 | keke    |

