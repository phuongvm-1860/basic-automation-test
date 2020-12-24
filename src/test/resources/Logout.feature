Feature: Logout
  As an user
  I want to log out

  Scenario:
    Given user signed in as "John Doe" and "ThisIsNotAPassword"
    When user clicks on menu
    And user clicks on logout button
    Then user logs out successfully
