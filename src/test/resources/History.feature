Feature: MakeAppointment

  An a user
  I want to sign in
  So I can use the app

  @automated
  Scenario: User can view history when register 2 make appointment
    Given user signed in with acc "John Doe" and "ThisIsNotAPassword"
    When user input as
      | facility                     | action    | Healthcare | date       | comment |
      | Tokyo CURA Healthcare Center | Checked   | Medicare   | 24/12/2020 | ABC     |
      | Seoul CURA Healthcare Center | Unchecked | None       | 24/12/2020 |         |
    And user clicks on Menu button
    And user clicks on history button
    Then user can sees list appointment as
      | facility_view                | action_view | Healthcare_view | date_view  | comment_view |
      | Tokyo CURA Healthcare Center | Yes         | Medicare        | 24/12/2020 | ABC          |
      | Seoul CURA Healthcare Center | No          | None            | 24/12/2020 |              |