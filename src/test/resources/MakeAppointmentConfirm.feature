Feature: Make Appointment

  An a user
  I want to sign in
  So I can use the app
  I make Appointment

  @automated
  Scenario Outline: User can make appointment with valid value
    Given user is in Katalon login pages
    When  user signed in as "John Doe" and "ThisIsNotAPassword"
    And user clicks on login buttons
    And user selects facility as "<facility>"
    And user "<action>" in checkbox
    And user clicks on "<HealthcareProgram>"
    And user selects visit date as "<date>"
    And user selects comment as "<comment>"
    And user clicks on Book Appointment button
    And user sees Appointment Confirmation page as below
      | facility   | action   | HealthcareProgram   | date   | comment   |
      | <facility> | <action> | <HealthcareProgram> | <date> | <comment> |
    Then user clicks on Homepage button
    Examples:
      | facility                     | action | HealthcareProgram | date       | comment |
      | Tokyo CURA Healthcare Center | Yes    | Medicare          | 12/10/2020 | ABC     |
      | Tokyo CURA Healthcare Center | No     | Medicaid          | 12/10/2020 | ABC     |
      | Tokyo CURA Healthcare Center | Yes    | None              | 12/10/2020 |         |

