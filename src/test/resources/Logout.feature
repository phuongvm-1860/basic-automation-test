Feature: User can logout
  As a user
  I want to logout
  So I can logout the app

  Scenario: User can logout after login
    Given user signed in with "John Doe" and "ThisIsNotAPassword"
    When user clicks on sidebar
    And user clicks on logout
    Then user sees top page

