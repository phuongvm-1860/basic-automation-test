Feature: MakeAppointment

  An a user
  I want to sign in
  So I can use the app

  @automated
  Scenario Outline: User can make appointment with valid value
    Given user signed in with "John Doe" and "ThisIsNotAPassword"
    When user selects facility as "<facility>"
    And user clicks on action "<action>"
    And user clicks on "<Healthcare>"
    And user selects visit date as "<date>"
    And user selects comment as "<comment>"
    And user clicks on Book Appointment button
    Then user sees "<facility>" and "<action>" in checkbox and "<Healthcare>" and "<date>" and "<comment>"
    And user clicks on Go to homepage button
    Then user sees homepage
    Examples:
      | facility                     | action  | Healthcare | date       | comment |
      | Tokyo CURA Healthcare Center | Checked | Medicare   | 12/10/2020 | ABC     |
      | Tokyo CURA Healthcare Center | Uncheck | Medicaid   | 12/10/2020 | ABC     |
      | Tokyo CURA Healthcare Center | Checked | None       | 12/10/2020 |         |

  Scenario Outline: User can make appointment with valid value
    Given user signed in with "John Doe" and "ThisIsNotAPassword"
    When user selects facility as "<facility>"
    And user clicks on action "<action>"
    And user clicks on "<Healthcare>"
    And user selects visit date as "<date>"
    And user selects comment as "<comment>"
    And user clicks on Book Appointment button
    Then user sees "<facility>" and "<action>" in checkbox and "<Healthcare>" and "<date>" and "<comment>"
    And user clicks on Go to homepage button
    Then user sees homepage
    Examples:
      | facility                        | action  | Healthcare | date       | comment |
      | Hongkong CURA Healthcare Center | Checked | Medicare   | 12/10/2020 | ABC     |
      | Hongkong CURA Healthcare Center | Uncheck | Medicaid   | 12/10/2020 | ABC     |
      | Hongkong CURA Healthcare Center | Checked | None       | 12/10/2020 |         |

  Scenario Outline: User can make appointment with valid value
    Given user signed in with "John Doe" and "ThisIsNotAPassword"
    When user selects facility as "<facility>"
    And user clicks on action "<action>"
    And user clicks on "<Healthcare>"
    And user selects visit date as "<date>"
    And user selects comment as "<comment>"
    And user clicks on Book Appointment button
    Then user sees "<facility>" and "<action>" in checkbox and "<Healthcare>" and "<date>" and "<comment>"
    And user clicks on Go to homepage button
    Then user sees homepage
    Examples:
      | facility                     | action  | Healthcare | date       | comment |
      | Seoul CURA Healthcare Center | Checked | Medicare   | 12/10/2020 | ABC     |
      | Seoul CURA Healthcare Center | Uncheck | Medicaid   | 12/10/2020 | ABC     |
      | Seoul CURA Healthcare Center | Checked | None       | 12/10/2020 |         |




