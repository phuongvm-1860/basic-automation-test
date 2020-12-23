Feature: Appointment confirmaion
  As an user
  I can confirm appointment is booked
  So i can confirm appointment is added

  Scenario: User confirm appointment
    Given user login with username as "John Doe" and password as "ThisIsNotAPassword"
    And user inputs facility as "Tokyo CURA Healthcare Center"
    And user selects status as "Checked"
    And user selects healthcare program as "Medicaid"
    And user inputs visit date as "06/12/2020"
    And user inputs comment as "Khong co comment 3"
    When user clicks on book appointment button
    Then user sees value exactly as below
      | facility                     | apply_for_hospital | health_care | visit_date | comment            |
      | Tokyo CURA Healthcare Center | Yes                | Medicaid    | 06/12/2020 | Khong co comment 3 |

