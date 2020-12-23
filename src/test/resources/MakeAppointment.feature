Feature: Make appointment
  An a user
  I want to make appointment
  So I can user function make appointment

  Scenario Outline: User can book appointment with valid value
    Given user login with username as "John Doe" and password as "ThisIsNotAPassword"
    When user inputs facility as "<facility>"
    And user selects status as "<apply_for_hospital>"
    And user selects healthcare program as "<health_care>"
    And user inputs visit date as "<visit_date>"
    And user inputs comment as "<comment>"
    And user clicks on book appointment button
    Then user sees appointment confirm screen is showed
    Examples:
      | facility                        | apply_for_hospital | health_care | visit_date | comment |
      | Tokyo CURA Healthcare Center    | Uncheck             | Medicare    | 02/12/2020 | abc1    |
      | Hongkong CURA Healthcare Center | Uncheck             | Medicaid    | 03/12/2020 | abc2    |
      | Seoul CURA Healthcare Center    | Checked             | None        | 04/12/2020 | abc3    |