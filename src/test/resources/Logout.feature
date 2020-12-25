Feature: MakeAppointment

  An a user
  I want to sign in
  So I can use the app

  @automated
  Scenario: User can logout at make appointment screen
    Given user signed in with "John Doe" and "ThisIsNotAPassword"
    When user clicks on menu button
    And user clicks on logout button
    Then user sees home screen