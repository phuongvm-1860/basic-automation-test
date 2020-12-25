Feature: Make Appointment

  An a user
  I want to sign in
  So I can use the app
  I make Appointment
  Then I view History

  @automated
  Scenario: User can make appointment with valid value
    Given user is in Katalon login pages
    When  user signed in as "John Doe" and "ThisIsNotAPassword"
    And user clicks on login buttons
    And user creat Appoinment as below
      | facility                     | action | HealthcareProgram | date       | comment |
      | Tokyo CURA Healthcare Center | Yes    | Medicare          | 12/10/2020 | ABC     |
      | Tokyo CURA Healthcare Center | No     | Medicaid          | 12/10/2020 | ABC     |
    And user clicks on sidebar
    And user clicks on History
    And user sees ViewHistory page as below
      | facility1                    | action1 | HealthcareProgram1 | date1      | comment1 |
      | Tokyo CURA Healthcare Center | Yes     | Medicare           | 12/10/2020 | ABC      |
      | Tokyo CURA Healthcare Center | No      | Medicaid           | 12/10/2020 | ABC      |
    Then user clicks on Homepage button

