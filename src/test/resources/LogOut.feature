Feature: LogOut
  An a user
  I want to sign out
  So I can sign out the app

  //@automated
  Scenario: User can sign out
    Given Given user signed in as "John Doe" and "ThisIsNotAPassword"
    When user clicks logout button on menu bar
    And user logout appointment page
    Then user can click login button on menubar


